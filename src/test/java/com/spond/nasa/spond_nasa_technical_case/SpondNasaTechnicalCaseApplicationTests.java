package com.spond.nasa.spond_nasa_technical_case;

import com.spond.nasa.spond_nasa_technical_case.controller.AsteroidController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpondNasaTechnicalCaseApplicationTests {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AsteroidController asteroidController;

//    @Test
//    public void testGetAsteroids() {
//        String startDate = "2021-01-01";
//        String endDate = "2021-01-07";
//        String expectedResponse = "{\"asteroids\": []}";
//        when(restTemplate.getForObject(anyString(), String.class)).thenReturn(expectedResponse);
//        String actualResponse = asteroidController.getAsteroids(startDate, endDate);
//        assertEquals(expectedResponse, actualResponse);
//    }




}
