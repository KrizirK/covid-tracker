package com.learning.covidtracker.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3275385010053544373L;

	@JsonProperty(value = "Country")
	private String countryName;
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

	public ReportDto() {
	}

	public ReportDto(String countryName, String countryCode, String status, String deaths, String recovered,
			String active, String date) {
		super();
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.status = status;
		this.deaths = deaths;
		this.recovered = recovered;
		this.active = active;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Country [country=" + countryName + ", countryCode=" + countryCode + ", status=" + status + ", deaths="
				+ deaths + ", recovered=" + recovered + ", active=" + active + ", date=" + date + "]";
	}

	public String getCountryCode() {
		return countryCode;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((deaths == null) ? 0 : deaths.hashCode());
		result = prime * result + ((recovered == null) ? 0 : recovered.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReportDto other = (ReportDto) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deaths == null) {
			if (other.deaths != null)
				return false;
		} else if (!deaths.equals(other.deaths))
			return false;
		if (recovered == null) {
			if (other.recovered != null)
				return false;
		} else if (!recovered.equals(other.recovered))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
