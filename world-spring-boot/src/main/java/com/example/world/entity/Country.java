package com.example.world.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Entity
@Table(name="country")
public class Country {
	@Id
	private String code;
	private String name;
	private String continent;
	@Column(name="surfacearea")
	private Double surfaceArea;
	private Integer population;
	private Double gnp;
	@JoinColumn(name="capital")
	@OneToOne
	private City capital;
	@OneToMany(mappedBy = "country",orphanRemoval = true)
	private Set<City> cities;


	public Country() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getPopulation() {
		return population;
	}

	public Set<City> getCities() {
		return cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", surfaceArea=" + surfaceArea
				+ ", population=" + population + ", gnp=" + gnp + ", capital=" + capital + ", cities=" + cities + "]";
	}

}