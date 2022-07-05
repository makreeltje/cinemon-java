package com.cinemon.domain.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class TMDbServiceImplTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    TMDbServiceImpl tmdbService;

    private URI mainTmdbUri;
    private String mainPosterPath;


    @BeforeEach
    void setUp() throws URISyntaxException {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(tmdbService, "apiKey", "8e8b06b1cb21b2d3f36f8bd44c933672");
        ReflectionTestUtils.setField(tmdbService, "baseUrl", "http://api.themoviedb.org/3");
        ReflectionTestUtils.setField(tmdbService, "imageUrl", "http://image.tmdb.org/t/p/w185_and_h278_bestv2");

        mainTmdbUri = new URI("http://api.themoviedb.org/3/movie/831946?api_key=8e8b06b1cb21b2d3f36f8bd44c933672");
        mainPosterPath = "http://image.tmdb.org/t/p/w185_and_h278_bestv2/cpWUtkcgRKeauhTyVMjYHxAutp4.jpg";
    }

    @Test
    void idUrlTest() throws URISyntaxException {
        var storedUri = tmdbService.idUrl(831946, "movie");
        log.debug(storedUri.toString());

        assertNotNull(storedUri);
        assertEquals(mainTmdbUri, storedUri);
    }

    @Test
    void posterPath() {
        var storedPosterPath = tmdbService.posterPath("cpWUtkcgRKeauhTyVMjYHxAutp4.jpg");
        log.debug(storedPosterPath);

        assertNotNull(storedPosterPath);
        assertEquals(mainPosterPath, storedPosterPath);
    }

//    @Test
//    void search() {
//
//        var storedMovie = tmdbService.search("The Matrix", "movie");
//
//    }
}
