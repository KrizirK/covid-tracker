package com.learning.covidtracker.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.covidtracker.domain.Country;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void shouldFindByName() {
		// Given
		Country country = new Country("testCountry0", "testSlug", "testIso2");
		// When
		countryRepository.save(country);
		// Then
		Country foundCountry = countryRepository.findByName("testCountry0");

		assertEquals(country, foundCountry);
	}

	@Test
	public void shouldFindAllByName() {
		// Given
		Country country0 = new Country("testCountry0", "testSlug", "testIso2");
		Country country1 = new Country("testCountry0", "testSlug", "testIso3");
		// When
		countryRepository.save(country0);
		countryRepository.save(country1);
		// Then
		List<Country> foundCountries = countryRepository.findAllByName("testCountry0");

		assertEquals(2, foundCountries.size());
	}

}
