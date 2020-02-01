package com.example.world.repository;

import com.example.world.entity.CountryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public interface CountryDocumentRepository extends MongoRepository<CountryDocument, String> {

    List<CountryDocument> findByContinent(String continent);
}
