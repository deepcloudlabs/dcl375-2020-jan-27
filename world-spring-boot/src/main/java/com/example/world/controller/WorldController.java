package com.example.world.controller;

import java.util.List;
import java.util.Set;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope // @Scope("request")
@RequestMapping("list")
public class WorldController {

    @Autowired
    private CountryRepository countryRepository;

    @ModelAttribute("continents") // ${continents}
    public Set<String> getContinents() {
        return countryRepository.getAllContinents();
    }

    @GetMapping
    public String openPage() {
        return "list";
    }

    @PostMapping
    public String listCountries(Model model,
                                @RequestParam("continent") String kita) {
        List<Country> countries =
                countryRepository.findByContinent(kita);
        // JSP EL: ${countries}
        model.addAttribute("countries", countries);
        return "list";
    }
}
