package com.cinemon.domain.services.plex;

import com.cinemon.domain.exceptions.PlexException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlexApiServiceImpl implements PlexApiService {

    @Value("${pms.url}")
    private String url;

    @Value("${pms.ip}")
    private String ip;

    @Value("${pms.port}")
    private String port;

    @Value("${pms.timeout}")
    private long timeout;

    @Value("${pms.authToken}")
    private String authToken;

    private final RestTemplate restTemplate;

    @Override
    public String getServerList() {
        log.info("Getting server list");
        var url = createUri("/servers");
        ResponseEntity<String> response = restTemplate.getForEntity(createUri("/servers"), String.class);
        log.info("Server list: {}", response.getBody());

        return response.getBody();
    }

    private URI createUri(String path) {
        Map<String, String> params = new HashMap<>();

        String url;
        if(this.url.isEmpty()) {
            url = "http://" + ip + ":" + port;
        } else {
            url = "https://" + this.url;
        }

        if(!this.authToken.isEmpty()) {
            params.put("X-Plex-Token", this.authToken);
        } else {
            throw new PlexException("No auth token provided");
        }

        return UriComponentsBuilder.fromHttpUrl(url)
                .path(path)
                .queryParam("X-Plex-Token", authToken)
                .build()
                .encode()
                .toUri();
    }
}
