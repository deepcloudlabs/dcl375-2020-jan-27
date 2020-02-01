package com.example.world.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class CityDocument {
    @Field("_id")
    private int id;
    private String name;
    private Integer population;

    public CityDocument() {
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
        CityDocument other = (CityDocument) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", population=" + population + "]";
    }

    ;

}
