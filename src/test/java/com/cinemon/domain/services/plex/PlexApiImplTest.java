package com.cinemon.domain.services.plex;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PlexApiImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PlexApiServiceImpl plexService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(plexService, "url", "plex.meelsnet.nl");
        ReflectionTestUtils.setField(plexService, "ip", "192.168.1.254");
        ReflectionTestUtils.setField(plexService, "port", "32400");
        ReflectionTestUtils.setField(plexService, "authToken", "uSjCuKSWyNhkiXYDQq5d");
    }

//    @Test
//    void getServerList() {
//        plexService.getServerList();
//    }
}