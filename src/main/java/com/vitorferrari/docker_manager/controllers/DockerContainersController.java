package com.vitorferrari.docker_manager.controllers;

import com.vitorferrari.docker_manager.services.DockerService;
import com.github.dockerjava.api.model.Container;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {

    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    // LISTAR CONTAINERS
    @GetMapping
    public ResponseEntity<List<Container>> listContainers(
            @RequestParam(defaultValue = "true") boolean showAll
    ) {
        List<Container> containers = dockerService.listContainers(showAll);
        return ResponseEntity.ok(containers);
    }

    // START CONTAINER
    @PostMapping("/{id}/start")
    public ResponseEntity<Void> startContainer(@PathVariable String id) {
        dockerService.startContainer(id);
        return ResponseEntity.ok().build();
    }

    // STOP CONTAINER
    @PostMapping("/{id}/stop")
    public ResponseEntity<Void> stopContainer(@PathVariable String id) {
        dockerService.stopContainer(id);
        return ResponseEntity.ok().build();
    }

    // DELETE CONTAINER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContainer(@PathVariable String id) {
        dockerService.deleteContainer(id);
        return ResponseEntity.noContent().build();
    }

    // CREATE CONTAINER
    @PostMapping
    public ResponseEntity<Void> createContainer(@RequestParam String imageName) {
        dockerService.createContainer(imageName);
        return ResponseEntity.ok().build();
    }
}