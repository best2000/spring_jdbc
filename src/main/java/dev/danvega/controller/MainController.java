package dev.danvega.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }
//    @PostMapping("/post-it")
//    public
}
