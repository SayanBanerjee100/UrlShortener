package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlRepository;
import com.example.urlshortener.util.ShortCodeGenerator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public UrlMapping createShortUrl(String originalUrl) {

        String shortCode = ShortCodeGenerator.generateShortCode();

        UrlMapping mapping = new UrlMapping(originalUrl, shortCode);

        return repository.save(mapping);
    }

    @Cacheable(value = "urls", key = "#shortCode")
    public Optional<UrlMapping> getOriginalUrl(String shortCode) {

        Optional<UrlMapping> mapping = repository.findByShortCode(shortCode);

        mapping.ifPresent(url -> {
            url.setClickCount(url.getClickCount() + 1);
            url.setLastAccessed(LocalDateTime.now());
            repository.save(url);
        });

        return mapping;
    }

    public UrlMapping getStats(String shortCode) {
        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}