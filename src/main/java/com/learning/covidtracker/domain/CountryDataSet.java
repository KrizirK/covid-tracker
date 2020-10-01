package com.learning.covidtracker.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountryDataSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String country;
	private String countryCode;
	private String slug;
	private Integer newConfirmed;
	private Integer totalConfirmed;
	private Integer newDeaths;
	private Integer totalDeaths;
	private Integer newRecovered;
	private Integer totalRecovered;

	private Date date;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CountryDataSet other = (CountryDataSet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public CountryDataSet() {
	}

	public CountryDataSet(Long id, String country, String countryCode, String slug, Integer newConfirmed,
			Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered,
			Integer totalRecovered, Date date) {
		super();
		this.id = id;
		this.country = country;
		this.countryCode = countryCode;
		this.slug = slug;
		this.newConfirmed = newConfirmed;
		this.totalConfirmed = totalConfirmed;
		this.newDeaths = newDeaths;
		this.totalDeaths = totalDeaths;
		this.newRecovered = newRecovered;
		this.totalRecovered = totalRecovered;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Integer getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(Integer newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public Integer getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Integer totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Integer getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Integer newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Integer getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Integer totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Integer getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(Integer newRecovered) {
		this.newRecovered = newRecovered;
	}

	public Integer getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Integer totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
