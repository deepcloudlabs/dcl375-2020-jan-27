package com.example.world.repository;
import java.util.List;
import java.util.Set;

import com.example.world.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface CountryRepository extends JpaRepository<Country,String> {

    List<Country> findByContinent(String continent);
    
    @Query("select distinct c.continent from Country c")
    Set<String> getAllContinents();
}
