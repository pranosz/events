package com.m_running.events;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/hello")
    public String greet() {
        return "Mountain Running Hello!";
    }
}
