package com.cinemon.web.model.response.plex;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ServerMediaContainer {
    private int size;
    @JsonProperty("Server")
    private List<ServerDetails> server = null;
}
