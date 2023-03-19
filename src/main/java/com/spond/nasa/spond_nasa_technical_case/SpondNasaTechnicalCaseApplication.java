package com.spond.nasa.spond_nasa_technical_case;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpondNasaTechnicalCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpondNasaTechnicalCaseApplication.class, args);
    }
}
