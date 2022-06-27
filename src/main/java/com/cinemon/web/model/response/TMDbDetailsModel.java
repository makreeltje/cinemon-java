package com.cinemon.web.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TMDbDetailsModel {
    @JsonProperty("results")
    List<TMDbResponseModel> results = new ArrayList<>();
}
