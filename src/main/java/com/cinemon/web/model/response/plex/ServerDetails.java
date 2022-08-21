package com.cinemon.web.model.response.plex;

import lombok.Data;

@Data
public class ServerDetails {
    private String name;
    private String host;
    private String address;
    private Integer port;
    private String machineIdentifier;
    private String version;
}
