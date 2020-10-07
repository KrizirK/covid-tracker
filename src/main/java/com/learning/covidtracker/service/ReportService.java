package com.learning.covidtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.repository.ReportRepository;
import com.learning.covidtracker.dto.ReportDto;
import com.learning.covidtracker.dto.mapper.ReportMapper;
import com.learning.covidtracker.service.ReportService;

@Service
public class ReportService {

	private final ReportRepository reportRepository;
	private final ReportMapper reportMapper;

	@Autowired
	public ReportService(ReportRepository reportRepository, ReportMapper reportMapper) {
		this.reportRepository = reportRepository;
		this.reportMapper = reportMapper;
	}

	public Iterable<ReportDto> findAll() {
		return reportMapper.convertEntities2Dtos(reportRepository.findAll());
	}

	public Iterable<ReportDto> findAllByName(String name) {
		return reportMapper.convertEntities2Dtos(reportRepository.findAllByCountryName(name));
	}

	public void saveAll(Iterable<ReportDto> reportsDto) {
		reportRepository.saveAll(reportMapper.convertDtos2Entities(reportsDto));
	}

}
