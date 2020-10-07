package com.learning.covidtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.repository.ReportRepository;
import com.learning.covidtracker.dto.ReportDto;
import com.learning.covidtracker.dto.mapper.ReportMapper;
import com.learning.covidtracker.service.ReportService;

@Service
public class ReportService {

	private final ReportRepository countryRepository;
	private final ReportMapper countryMapper;

	@Autowired
	public ReportService(ReportRepository countryRepository, ReportMapper countryMapper) {
		this.countryRepository = countryRepository;
		this.countryMapper = countryMapper;
	}

	public Iterable<ReportDto> findAll() {
		return countryMapper.convertEntities2Dtos(countryRepository.findAll());
	}

	public Iterable<ReportDto> findAllByName(String name) {
		return countryMapper.convertEntities2Dtos(countryRepository.findByCountryName(name));
	}
	
	public void saveAll(Iterable<ReportDto> countriesDto){
		countryRepository.saveAll(countryMapper.convertDtos2Entities(countriesDto));
	}
	
	

}
