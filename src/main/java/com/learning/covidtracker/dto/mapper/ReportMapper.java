package com.learning.covidtracker.dto.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.covidtracker.domain.Report;
import com.learning.covidtracker.dto.ReportDto;

@Service
public class ReportMapper {

	public Report convertDto2Entity(ReportDto reportDto) {
		Report report = new Report();

		report.setCountryName(reportDto.getCountryName());
		report.setCountryCode(reportDto.getCountryCode());
		report.setStatus(reportDto.getStatus());
		report.setDeaths(reportDto.getDeaths());
		report.setRecovered(reportDto.getRecovered());
		report.setActive(reportDto.getActive());
		report.setDate(reportDto.getDate());

		return report;
	}

	public List<Report> convertDtos2Entities(Iterable<ReportDto> reportDto) {
		/* UGLY FIX */
		return ((Collection<ReportDto>) reportDto).stream().map(this::convertDto2Entity)
				.collect(Collectors.toList());
	}

	public ReportDto convertEntity2Dto(Report report) {
		ReportDto reportDto = new ReportDto();

		reportDto.setCountryName(report.getCountryName());
		reportDto.setCountryCode(report.getCountryCode());
		reportDto.setStatus(report.getStatus());
		reportDto.setDeaths(report.getDeaths());
		reportDto.setRecovered(report.getRecovered());
		reportDto.setActive(report.getActive());
		reportDto.setDate(report.getDate());

		return reportDto;
	}

	public Iterable<ReportDto> convertEntities2Dtos(Iterable<Report> reports) {
		/* UGLY FIX */
		return ((Collection<Report>) reports).stream().map(this::convertEntity2Dto).collect(Collectors.toList());
	}

}
