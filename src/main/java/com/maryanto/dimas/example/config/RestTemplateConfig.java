package com.maryanto.dimas.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class RestTemplateConfig {

    private final Integer port;
    private final String contextPath;

    public RestTemplateConfig(
            @Value("${server.port}") Integer port,
            @Value("${server.servlet.context-path}") String contextPath) {
        this.port = port;
        this.contextPath = contextPath;
    }

    @Bean
    public RestTemplate restTemplate(
            RestTemplateBuilder builder) {
        log.info("application port: {}, contextPath: {}", port, contextPath);
        StringBuilder rootUri = new StringBuilder("http://localhost:").append(port).append(contextPath);
        return builder
                .rootUri(rootUri.toString())
                .build();
    }
}
