package com.learning.covidtracker.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.covidtracker.domain.Report;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ReportRepositoryTest {

	@Autowired
	private ReportRepository reportRepository;

	@Test
	public void shouldFindByName() {
		// Given
		Report report = new Report("countryName", "countryCode", "status", "deaths", "recovered", "active", "date");
		// When
		reportRepository.save(report);
		// Then
		List<Report> foundReports = reportRepository.findAllByCountryName("countryName");

		assertEquals(1, foundReports.size());
	}

}
