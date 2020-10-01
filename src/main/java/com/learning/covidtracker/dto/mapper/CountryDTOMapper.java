package com.learning.covidtracker.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.Country;
import com.learning.covidtracker.domain.repository.CountryRepository;
import com.learning.covidtracker.dto.CountryDTO;

@Service
public class CountryDTOMapper {

	@Autowired
	private CountryRepository countryRepository;

	public Country convertCountryDTO2Entity(CountryDTO countryDTO) {
		Country country = new Country();

		country.setCountry(countryDTO.getCountry());
		country.setCountryCode(countryDTO.getCountryCode());
		country.setStatus(countryDTO.getStatus());
		country.setDeaths(countryDTO.getDeaths());
		country.setRecovered(countryDTO.getRecovered());
		country.setActive(countryDTO.getActive());
		country.setDate(countryDTO.getDate());

		return country;
	}

	public List<Country> convertCountriesDTO2Entities(List<CountryDTO> countriesDTO) {

		return countriesDTO.stream().map(this::convertCountryDTO2Entity).collect(Collectors.toList());
	}

}
