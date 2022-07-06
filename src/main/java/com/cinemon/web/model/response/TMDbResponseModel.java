package com.cinemon.web.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TMDbResponseModel {
    private Long id;
    private String overview;
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("release_date")
    private String releaseDate;
    private boolean adult;
}
