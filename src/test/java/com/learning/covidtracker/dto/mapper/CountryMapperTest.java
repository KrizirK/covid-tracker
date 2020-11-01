package com.learning.covidtracker.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.covidtracker.domain.Country;
import com.learning.covidtracker.dto.CountryDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CountryMapperTest {

	@Autowired
	private CountryMapper countryMapper;

	@Test
	public void shouldMapEntity2Dto() {
		// Given
		Country country = new Country("name", "slug", "iso2");
		CountryDto countryDto = new CountryDto("name", "slug", "iso2");
		// When
		CountryDto countryMapped = countryMapper.convertEntity2Dto(country);
		// Then
		assertEquals(countryMapped, countryDto);
	}

	@Test
	public void shouldMapEntities2Dto() {
		// Given
		Country country = new Country("name", "slug", "iso2");
		Country country1 = new Country("name1", "slug1", "iso21");
		List<Country> listOfCountries = new LinkedList<Country>();
		listOfCountries.add(country);
		listOfCountries.add(country1);

		CountryDto countryDto = new CountryDto("name", "slug", "iso2");
		CountryDto countryDto1 = new CountryDto("name1", "slug1", "iso21");
		List<CountryDto> listOfCountryDtos = new LinkedList<CountryDto>();
		listOfCountryDtos.add(countryDto);
		listOfCountryDtos.add(countryDto1);
		// When
		List<CountryDto> countriesMapped = (List<CountryDto>) countryMapper.convertEntities2Dtos(listOfCountries);
		// Then
		assertEquals(listOfCountries.size(), countriesMapped.size());
	}

}
