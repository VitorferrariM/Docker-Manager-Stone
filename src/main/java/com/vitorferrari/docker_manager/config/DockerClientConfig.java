package com.vitorferrari.docker_manager.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;

@Configuration
public class DockerClientConfig {

    @Value("${docker.socket.path:}")
    private String dockerSocketPath;

    @Bean
    @Lazy(false)
    public DockerClient dockerClient() {

        DefaultDockerClientConfig.Builder configBuilder =
                DefaultDockerClientConfig.createDefaultConfigBuilder();

        // 🔥 prioridade: socket customizado (Linux/WSL)
        if (dockerSocketPath != null && dockerSocketPath.startsWith("unix://")) {
            configBuilder
                    .withDockerHost(dockerSocketPath)
                    .withDockerTlsVerify(false);
        } else {
            // 🔥 fallback Windows Docker Desktop
            configBuilder
                    .withDockerHost("tcp://localhost:2375")
                    .withDockerTlsVerify(false);
        }

        DefaultDockerClientConfig config = configBuilder.build();

        ApacheDockerHttpClient httpClient =
                new ApacheDockerHttpClient.Builder()
                        .dockerHost(config.getDockerHost())
                        .connectionTimeout(Duration.ofSeconds(10))
                        .responseTimeout(Duration.ofSeconds(15))
                        .maxConnections(20)
                        .build();

        DockerClient client = DockerClientImpl.getInstance(config, httpClient);

        // test connection (vai falhar aqui se Docker não estiver acessível)
        client.pingCmd().exec();

        return client;
    }
}