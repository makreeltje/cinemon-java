package com.cinemon.web.model.response.plex;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Server {
    @JsonProperty("MediaContainer")
    private ServerMediaContainer mediaContainer;
}
