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
		country.setSlug(countryDto.getSlug());
		country.setIso2(countryDto.getIso2());

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
		countryDto.setSlug(country.getSlug());
		countryDto.setIso2(country.getIso2());

		return countryDto;
	}

	public Iterable<CountryDto> convertEntities2Dtos(Iterable<Country> countries) {
		/* UGLY FIX */
		return ((Collection<Country>) countries).stream().map(this::convertEntity2Dto).collect(Collectors.toList());
	}

}
