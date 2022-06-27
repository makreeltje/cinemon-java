package com.cinemon.web.controllers;

import com.cinemon.domain.exceptions.NotFoundException;
import com.cinemon.domain.services.TMDbService;
import com.cinemon.web.model.response.TMDbDetailsModel;
import com.cinemon.web.model.response.TMDbResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.cinemon.domain.utils.APIUtils.SHOW_TYPES;

import java.net.URISyntaxException;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/tmdb")
@RequiredArgsConstructor
@Validated
@Slf4j
public class TMDBController {

    private final RestTemplate restTemplate;
    private final TMDbService service;

    @GetMapping("/{id}")
    public ResponseEntity<TMDbResponseModel> getById(@PathVariable("id") long id) throws NotFoundException, URISyntaxException {
        log.info("Getting movie by id {}", id);
        TMDbResponseModel responseModel =
                restTemplate.getForObject(
                        service.idUrl(id, SHOW_TYPES.MOVIE.name()), TMDbResponseModel.class);

        if (Objects.isNull(responseModel)) {
            log.error("MovieDB entry with id \" + id + \" not found");
            throw new NotFoundException("MovieDB entry with id " + id + " not found");
        }
        log.info("Found movie {}", responseModel);
        return ResponseEntity.ok(responseModel);
    }

    @GetMapping("/search")
    public ResponseEntity<TMDbDetailsModel> search(@RequestParam("name") String name, @RequestParam("type") String type) throws NotFoundException {
        log.info("Search request for {} show {}", name, type);

        TMDbDetailsModel responseModel =
                service.search(name, type);

        if (!responseModel.getResults().isEmpty()) {
            log.info("Found {} show {}", name, type);
            responseModel.getResults().forEach(
                    result -> {
                        if (result.getPosterPath() != null) {
                            result.setPosterPath(service.posterPath(result.getPosterPath()));
                        }
                    }
            );
            return ResponseEntity.ok(responseModel);
        } else {
            log.error("Show {} {} not found", name, type);
            return ResponseEntity.status(404).build();
        }
    }
}
