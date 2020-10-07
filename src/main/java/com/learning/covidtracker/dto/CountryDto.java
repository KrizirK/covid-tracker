package com.learning.covidtracker.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3275385010053544373L;

	@JsonProperty(value = "Country")
	private String name;
	@JsonProperty(value = "CountryCode")
	private String countryCode;
	@JsonProperty(value = "Confirmed")
	private String status;
	@JsonProperty(value = "Deaths")
	private String deaths;
	@JsonProperty(value = "Recovered")
	private String recovered;
	@JsonProperty(value = "Active")
	private String active;
	@JsonProperty(value = "Date")
	private String date;

	public CountryDto() {
	}

	public CountryDto(String name, String countryCode, String status, String deaths, String recovered, String active,
			String date) {
		super();
		this.name = name;
		this.countryCode = countryCode;
		this.status = status;
		this.deaths = deaths;
		this.recovered = recovered;
		this.active = active;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Country [country=" + name + ", countryCode=" + countryCode + ", status=" + status + ", deaths=" + deaths
				+ ", recovered=" + recovered + ", active=" + active + ", date=" + date + "]";
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
