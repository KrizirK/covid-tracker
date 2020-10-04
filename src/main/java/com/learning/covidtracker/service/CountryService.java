package com.learning.covidtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.Country;
import com.learning.covidtracker.domain.repository.CountryRepository;
import com.learning.covidtracker.dto.CountryDto;
import com.learning.covidtracker.dto.mapper.CountryMapper;
import com.learning.covidtracker.service.CountryService;

@Service
public class CountryService {

	private final CountryRepository countryRepository;
	private final CountryMapper countryMapper;

	@Autowired
	public CountryService(CountryRepository countryRepository, CountryMapper countryMapper) {
		this.countryRepository = countryRepository;
		this.countryMapper = countryMapper;
	}

	public Iterable<CountryDto> findAll() {
		return countryMapper.convertEntities2Dtos(countryRepository.findAll());
	}
	
	public void saveAll(Iterable<CountryDto> countriesDto){
		countryRepository.saveAll(countryMapper.convertDtos2Entities(countriesDto));
	}

}