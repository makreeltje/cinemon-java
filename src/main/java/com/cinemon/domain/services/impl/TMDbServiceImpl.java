package com.cinemon.domain.services.impl;

import com.cinemon.domain.exceptions.NotFoundException;
import com.cinemon.domain.services.TMDbService;
import com.cinemon.web.model.response.TMDbDetailsModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cinemon.domain.utils.APIUtils.SHOW_TYPES;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class TMDbServiceImpl implements TMDbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String baseUrl;

    @Value("${tmdb.image.url}")
    private String imageUrl;

    private static final String SEARCH_MOVIE_URL = "/search/movie";
    private static final String SEARCH_TV_URL = "/search/tv";

    private static final String IMDB_URL = "https://www.imdb.com/title";
    private final RestTemplate restTemplate;


    @Override
    public URI idUrl(long id, String type) throws URISyntaxException {
        String url = String.format("%s/%s/%d?api_key=%s", baseUrl, type.equalsIgnoreCase(SHOW_TYPES.MOVIE.name()) ? "movie" : "tv", id, apiKey);
        log.debug(url);
        return new URI(url);
    }

    @Override
    public String posterPath(String posterPath) {
        return imageUrl.concat("/").concat(posterPath);
    }

    @Override
    public TMDbDetailsModel search(String name, String type) throws NotFoundException {
        URI uri = generateSearchUrl(name, type);
        log.info("Searching for {} show {}", name, type);
        TMDbDetailsModel responseModel = restTemplate.getForObject(uri, TMDbDetailsModel.class);
        if(responseModel.getResults().isEmpty()) {
            log.error("No results found for {} show {}", name, type);
            throw new NotFoundException("No results found for " + name + " " + type);
        }
        log.debug(responseModel.toString());
        return responseModel;
    }

    private URI generateSearchUrl(String name, String type) {
        String searchUrl = baseUrl;

        searchUrl.concat(type.equalsIgnoreCase(SHOW_TYPES.MOVIE.name()) ? SEARCH_MOVIE_URL : SEARCH_TV_URL);

        Map<String, String> params = new HashMap<>();
        params.put("api_key", apiKey);
        params.put("query", name);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(searchUrl);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        URI uri = builder.encode().build().toUri();

        log.debug(uri.toString());
        return uri;
    }
}
