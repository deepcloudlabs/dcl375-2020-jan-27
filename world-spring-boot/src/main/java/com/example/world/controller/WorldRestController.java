package com.example.world.controller;

import java.util.List;

import com.example.world.entity.Country;
import com.example.world.entity.CountryDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.repository.CountryDocumentRepository;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@RestController
@RequestScope
@CrossOrigin
public class WorldRestController {
    @Autowired
    private CountryDocumentRepository countryDocumentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/continents")
    public List<String> getAllContinents() {
        return mongoTemplate.query(Country.class).distinct("continent").as(String.class).all();
    }

    @GetMapping("/countries")
    public List<CountryDocument> getCountriesByContinent(@RequestParam(required = false, defaultValue = "Asia") String continent) {
        return countryDocumentRepository.findByContinent(continent);
    }
}
