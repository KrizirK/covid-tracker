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

import com.learning.covidtracker.domain.Report;
import com.learning.covidtracker.dto.ReportDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ReportMapperTest {

	@Autowired
	private ReportMapper reportMapper;

	@Test
	public void shouldMapEntity2Dto() {
		// Given
		Report report = new Report("countryName", "countryCode", "status", "deaths", "recovered", "active", "date");
		ReportDto reportDto = new ReportDto("countryName", "countryCode", "status", "deaths", "recovered", "active", "date");
		// When
		ReportDto reportMapped = reportMapper.convertEntity2Dto(report);
		// Then
		assertEquals(reportMapped, reportDto);
	}

	@Test
	public void shouldMapEntities2Dto() {
		// Given
		Report report = new Report("countryName", "countryCode", "status", "deaths", "recovered", "active", "date");
		Report report1 = new Report("countryName1", "countryCode1", "status1", "deaths1", "recovered1", "active1", "date1");
		List<Report> listOfReports = new LinkedList<Report>();
		listOfReports.add(report);
		listOfReports.add(report1);

		ReportDto countryDto = new ReportDto("countryName", "countryCode", "status", "deaths", "recovered", "active", "date");
		ReportDto countryDto1 = new ReportDto("countryName1", "countryCode1", "status1", "deaths1", "recovered1", "active1", "date1");
		List<ReportDto> listOfReportDtos = new LinkedList<ReportDto>();
		listOfReportDtos.add(countryDto);
		listOfReportDtos.add(countryDto1);
		// When
		List<ReportDto> reportsMapped = (List<ReportDto>) reportMapper.convertEntities2Dtos(listOfReports);
		// Then
		assertEquals(listOfReports.size(), reportsMapped.size());
	}

}
