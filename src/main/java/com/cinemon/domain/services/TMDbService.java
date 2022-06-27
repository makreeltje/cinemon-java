package com.cinemon.domain.services;

import com.cinemon.domain.exceptions.NotFoundException;
import com.cinemon.web.model.response.TMDbDetailsModel;

import java.net.URI;
import java.net.URISyntaxException;

public interface TMDbService {
    URI idUrl(long id, String type) throws URISyntaxException;
    String posterPath(String posterPath);

    TMDbDetailsModel search(String name, String type) throws NotFoundException;
}
