package com.project.Microbussiness.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Inventory Backend is Live and Connected to Aiven MySQL!";
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}