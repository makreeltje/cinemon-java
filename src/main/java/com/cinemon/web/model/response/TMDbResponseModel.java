package com.cinemon.web.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TMDbResponseModel {
    private Long id;
    private String overview;
    @JsonProperty("imdb_id")
    private String imdbId;
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("release_date")
    private String releaseDate;
    private boolean adult;
    private Long runtime;
    private String status;
}
