package com.example.world.repository;

import com.example.world.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public interface CountryRepository extends MongoRepository<Country, String> {

    List<Country> findByContinent(String continent);
}
