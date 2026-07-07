package com.vitorferrari.docker_manager.services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.exception.NotModifiedException;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    public DockerService(DockerClient client) {
        this.dockerClient = client;
    }

    // LISTAR CONTAINERS
    public List<Container> listContainers(boolean all) {
        return dockerClient.listContainersCmd()
                .withShowAll(all)
                .exec();
    }

    // LISTAR IMAGENS
    public List<Image> listImages() {
        return dockerClient.listImagesCmd().exec();
    }

    // FILTRAR IMAGENS
    public List<Image> filterImages(String filterName) {
        return dockerClient.listImagesCmd()
                .withImageNameFilter(filterName)
                .exec();
    }

    // START CONTAINER
    public void startContainer(String containerId) {
        try {
            dockerClient.startContainerCmd(containerId).exec();
        } catch (NotModifiedException e) {
            // já está rodando → ignora
        } catch (NotFoundException e) {
            throw new RuntimeException("Container não encontrado: " + containerId);
        }
    }

    // STOP CONTAINER
    public void stopContainer(String containerId) {
        try {
            dockerClient.stopContainerCmd(containerId).exec();
        } catch (NotModifiedException e) {
            // já está parado → ignora
        } catch (NotFoundException e) {
            throw new RuntimeException("Container não encontrado: " + containerId);
        }
    }

    // DELETE CONTAINER
    public void deleteContainer(String containerId) {
        try {
            dockerClient.removeContainerCmd(containerId).exec();
        } catch (NotFoundException e) {
            throw new RuntimeException("Container não encontrado: " + containerId);
        }
    }

    // CREATE CONTAINER
    public void createContainer(String imageName) {
        dockerClient.createContainerCmd(imageName).exec();
    }
}
