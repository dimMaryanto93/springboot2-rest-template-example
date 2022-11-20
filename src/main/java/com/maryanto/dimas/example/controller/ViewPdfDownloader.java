package com.maryanto.dimas.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/report")
public class ViewPdfDownloader {

    private final RestTemplate restTemplate;

    @Autowired
    public ViewPdfDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/sign")
    public ResponseEntity<?> getReportFromHtml() throws IOException {
        return this.restTemplate.getForEntity("/app/report/sign", String.class);
    }

}
