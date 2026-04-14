package com.example.urlshortener.controller;

import com.example.urlshortener.dto.*;
import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public UrlResponse createShortUrl(@RequestBody UrlRequest request) {

        UrlMapping mapping = service.createShortUrl(request.getOriginalUrl());

        return new UrlResponse("http://localhost:8080/api/" + mapping.getShortCode());
    }

    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode,
                         HttpServletResponse response) throws IOException {

        Optional<UrlMapping> mapping = service.getOriginalUrl(shortCode);

        if(mapping.isPresent()) {
            response.sendRedirect(mapping.get().getOriginalUrl());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}