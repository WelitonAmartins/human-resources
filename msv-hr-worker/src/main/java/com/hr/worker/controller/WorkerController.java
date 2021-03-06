package com.hr.worker.controller;

import com.hr.worker.entity.Worker;
import com.hr.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RequiredArgsConstructor
@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerController {

    private final WorkerRepository workerRepository;

    private final Environment env;

    @Value("${test.config}")
    private String testConfig;


    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        log.info("PORT = "+ env.getProperty("local.server.port"));

        return ResponseEntity.ok(workerRepository.findById(id).orElse(null));
    }
}
