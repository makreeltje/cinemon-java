package com.cinemon.domain.services.impl;

import com.cinemon.web.model.response.TMDbDetailsModel;
import com.cinemon.web.model.response.TMDbResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TMDbServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TMDbServiceImpl tmdbService;

    private URI mainTmdbUri;
    private String mainPosterPath;
    private TMDbDetailsModel mainDetailsResponseModel;
    private TMDbResponseModel mainResponseModel;


    @BeforeEach
    void setUp() throws URISyntaxException {
        ReflectionTestUtils.setField(tmdbService, "apiKey", "8e8b06b1cb21b2d3f36f8bd44c933672");
        ReflectionTestUtils.setField(tmdbService, "baseUrl", "https://api.themoviedb.org/3");
        ReflectionTestUtils.setField(tmdbService, "imageUrl", "https://image.tmdb.org/t/p/w185_and_h278_bestv2");

        mainTmdbUri = new URI("https://api.themoviedb.org/3/movie/831946?api_key=8e8b06b1cb21b2d3f36f8bd44c933672");
        mainPosterPath = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/cpWUtkcgRKeauhTyVMjYHxAutp4.jpg";

        mainResponseModel = new TMDbResponseModel();
        mainResponseModel.setId(589761L);
        mainResponseModel.setTitle("Chernobyl: Abyss");
        mainResponseModel.setPosterPath("https://image.tmdb.org/t/p/w185_and_h278_bestv2/AmJLuHjxPdIJO6vmymeWADG6jK5.jpg");
        mainResponseModel.setAdult(false);
        mainResponseModel.setOverview("The aftermath of a shocking explosion at the Chernobyl nuclear power station made hundreds of people sacrifice their lives to clean up the site of the catastrophe and to successfully prevent an even bigger disaster that could have turned a large part of the European continent into an uninhabitable exclusion zone. This is their story.");
        mainResponseModel.setReleaseDate("2021-04-15");
        mainResponseModel.setOriginalLanguage("ru");

        mainDetailsResponseModel = new TMDbDetailsModel();
        mainDetailsResponseModel.setResults(List.of(mainResponseModel));
    }

    @Test
    void idUrlTest() throws URISyntaxException {
        var storedUri = tmdbService.idUrl(831946, "movie");
        log.debug(storedUri.toString());

        assertNotNull(storedUri);
        assertEquals(mainTmdbUri, storedUri);
    }

    @Test
    void posterPathTest() {
        var storedPosterPath = tmdbService.posterPath("cpWUtkcgRKeauhTyVMjYHxAutp4.jpg");
        log.debug(storedPosterPath);

        assertNotNull(storedPosterPath);
        assertEquals(mainPosterPath, storedPosterPath);
    }

    @Test
    void searchMovieTest() {
        when(restTemplate.getForObject(any(URI.class), eq(TMDbDetailsModel.class))).thenReturn(mainDetailsResponseModel);

        var storedMovie = tmdbService.search("The Matrix", "movie");

        log.debug(storedMovie.toString());

        assertNotNull(storedMovie);
        assertEquals(mainDetailsResponseModel, storedMovie);
        verify(restTemplate, times(1)).getForObject(any(URI.class), eq(TMDbDetailsModel.class));
    }
}
