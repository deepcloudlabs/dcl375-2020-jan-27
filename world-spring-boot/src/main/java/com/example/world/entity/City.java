package com.example.world.entity;

import javax.persistence.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    private int id;
    private String name;
    private Integer population;
    @JoinColumn(name = "countrycode")
    @ManyToOne
    private Country country;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", population=" + population + ", countryCode=" + country.getCode()
                + "]";
    }

    ;

}
