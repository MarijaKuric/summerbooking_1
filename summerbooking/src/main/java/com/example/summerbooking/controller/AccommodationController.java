package com.example.summerbooking.controller;

import com.example.summerbooking.model.Accommodation;
import com.example.summerbooking.service.AccommodationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    // LISTA
    @GetMapping
    public String list(Model model) {

        model.addAttribute("accommodations",
                accommodationService.getAll());

        return "accommodations/list";
    }

    // DETAILS
    @GetMapping("/{id}")
    public String details(@PathVariable Long id,
                          Model model) {

        Accommodation accommodation = accommodationService
                .getById(id)
                .orElseThrow();

        model.addAttribute("accommodation",
                accommodation);

        return "accommodations/details";
    }

    // FORM ADD
    @GetMapping("/new")
    public String createForm(Model model) {

        model.addAttribute("accommodation",
                new Accommodation());

        return "accommodations/form";
    }

    // SAVE
    @PostMapping
    public String save(@Valid @ModelAttribute Accommodation accommodation,
                       BindingResult result) {

        if (result.hasErrors()) {
            return "accommodations/form";
        }

        accommodationService.save(accommodation);

        return "redirect:/accommodations";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id,
                           Model model) {

        Accommodation accommodation = accommodationService
                .getById(id)
                .orElseThrow();

        model.addAttribute("accommodation",
                accommodation);

        return "accommodations/form";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        accommodationService.delete(id);

        return "redirect:/accommodations";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword,
                         Model model) {

        model.addAttribute("accommodations",
                accommodationService.search(keyword));

        return "accommodations/list";
    }
    @GetMapping("/sort")
    public String sort(@RequestParam String direction,
                       Model model) {

        if(direction.equals("asc")) {

            model.addAttribute("accommodations",
                    accommodationService.sortByPriceAsc());

        } else {

            model.addAttribute("accommodations",
                    accommodationService.sortByPriceDesc());
        }

        return "accommodations/list";
    }
}