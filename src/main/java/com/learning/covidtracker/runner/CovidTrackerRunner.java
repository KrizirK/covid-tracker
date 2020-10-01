package com.learning.covidtracker.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.covidtracker.dto.CountryDTO;
import com.learning.covidtracker.dto.mapper.CountryDTOMapper;
import com.learning.covidtracker.domain.Country;
import com.learning.covidtracker.domain.repository.CountryRepository;

@Component
public class CovidTrackerRunner implements CommandLineRunner {

	private final CountryRepository countryRepository;

	private final CountryDTOMapper countryDTOMapper;

	@Autowired
	public CovidTrackerRunner(CountryRepository countryRepository, CountryDTOMapper countryDTOMapper) {
		this.countryRepository = countryRepository;
		this.countryDTOMapper = countryDTOMapper;
	}

	@Override
	public void run(String... args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		CountryDTO[] countries = restTemplate.getForObject("https://api.covid19api.com/total/country/poland",
				CountryDTO[].class);

		List<CountryDTO> countriesDTO = Arrays.asList(countries);

		List<Country> countryEntities = countryDTOMapper.convertCountriesDTO2Entities(countriesDTO);

		countryRepository.saveAll(countryEntities);
		
		System.out.println("Finished!");
	}
}
