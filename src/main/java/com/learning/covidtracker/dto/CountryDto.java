package com.learning.covidtracker.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2523011783087613494L;

	@JsonProperty(value = "Country")
	private String name;
	@JsonProperty(value = "Slug")
	private String slug;
	@JsonProperty(value = "ISO2")
	private String iso2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	@Override
	public String toString() {
		return "CountryDto [name=" + name + ", slug=" + slug + ", iso2=" + iso2 + "]";
	}

	public CountryDto() {
	}

	public CountryDto(String name, String slug, String iso2) {
		super();
		this.name = name;
		this.slug = slug;
		this.iso2 = iso2;
	}

}
