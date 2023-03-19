package com.spond.nasa.spond_nasa_technical_case.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // Change this to your own port if necessary, I'm using port 3000 for frontend
@RestController
public class AsteroidController {
    private static final String API_KEY = "QcCulg7XUdb4GoMeq4h3v8xRKv2gGtC91MfkDaZU"; //Personalized API NASA key
    private final RestTemplate restTemplate = new RestTemplate();
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    @GetMapping("/api/asteroids")
    public String getAsteroids(@RequestParam("startDate") String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate endDate = start.plusDays(7); // Calculate endDate date as 7 days after start date
        String key = "asteroids_" + startDate + "_" + endDate;
        if (cache.containsKey(key)) {
            System.out.println("Cache hit"); // For testing purposes
            return cache.get(key);
        } else {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + API_KEY;
            String result = restTemplate.getForObject(url, String.class);
            assert result != null;
            cache.put(key, result);
            return result;
        }
    }

    // Method for getting asteroids between two dates
    @GetMapping("/api/asteroids/{startDate}/{endDate}")
    public String getAsteroids(@PathVariable String startDate, @PathVariable String endDate) {
        String key = "asteroids_" + startDate + "_" + endDate;
        if (cache.containsKey(key)) {
            System.out.println("Cache hit"); // For testing purposes
            return cache.get(key);
        } else {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + API_KEY;
            String result = restTemplate.getForObject(url, String.class);
            assert result != null;
            cache.put(key, result);
            return result;
        }
    }

    // Method for getting asteroid by id
    @GetMapping("/api/asteroid")
    public String getAsteroid(@RequestParam String id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            String url = "https://api.nasa.gov/neo/rest/v1/neo/" + id + "?api_key=" + API_KEY;
            String result = restTemplate.getForObject(url, String.class);
            assert result != null;
            cache.put(id, result);
            return result;
        }
    }
}