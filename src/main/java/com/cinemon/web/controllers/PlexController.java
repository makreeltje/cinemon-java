package com.cinemon.web.controllers;

import com.cinemon.domain.services.plex.PlexApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/plex")
@RequiredArgsConstructor
@Validated
@Slf4j
public class PlexController {
    private final RestTemplate restTemplate;
    private final PlexApiService service;

    @GetMapping("/servers")
    public ResponseEntity<String> getServerList() {
        log.info("Getting server list");
        String response = service.getServerList();
        log.info("Found server list {}", response);
        return ResponseEntity.ok(response);
    }
}
