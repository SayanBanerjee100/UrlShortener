package com.example.urlshortener.dto;

import java.time.LocalDateTime;

public class UrlStatsResponse {

    private String originalUrl;
    private long clicks;
    private LocalDateTime createdAt;

    public UrlStatsResponse(String originalUrl, long clicks, LocalDateTime createdAt) {
        this.originalUrl = originalUrl;
        this.clicks = clicks;
        this.createdAt = createdAt;
    }
}