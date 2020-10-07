package com.learning.covidtracker.dto.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.Country;
import com.learning.covidtracker.dto.CountryDto;

@Service
public class CountryMapper {

	public Country convertDto2Entity(CountryDto countryDto) {
		Country country = new Country();

		country.setName(countryDto.getName());
		country.setCountryCode(countryDto.getCountryCode());
		country.setStatus(countryDto.getStatus());
		country.setDeaths(countryDto.getDeaths());
		country.setRecovered(countryDto.getRecovered());
		country.setActive(countryDto.getActive());
		country.setDate(countryDto.getDate());

		return country;
	}

	public List<Country> convertDtos2Entities(Iterable<CountryDto> countriesDto) {
		/* UGLY FIX */
		return ((Collection<CountryDto>) countriesDto).stream().map(this::convertDto2Entity)
				.collect(Collectors.toList());
	}

	public CountryDto convertEntity2Dto(Country country) {
		CountryDto countryDto = new CountryDto();

		countryDto.setName(country.getName());
		countryDto.setCountryCode(country.getCountryCode());
		countryDto.setStatus(country.getStatus());
		countryDto.setDeaths(country.getDeaths());
		countryDto.setRecovered(country.getRecovered());
		countryDto.setActive(country.getActive());
		countryDto.setDate(country.getDate());

		return countryDto;
	}

	public Iterable<CountryDto> convertEntities2Dtos(Iterable<Country> countries) {
		/* UGLY FIX */
		return ((Collection<Country>) countries).stream().map(this::convertEntity2Dto).collect(Collectors.toList());
	}

}
