package com.example.summerbooking.controller;

import com.example.summerbooking.service.AccommodationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AccommodationService accommodationService;

    public HomeController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("accommodationCount",
                accommodationService.getAll().size());

        return "index";
    }
}