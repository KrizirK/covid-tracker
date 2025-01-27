package com.learning.covidtracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.covidtracker.service.external.RestService;

@Service
public class DataImportService {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final ReportService reportService;
	private final CountryService countryService;
	
	private final RestService restService;

	@Autowired
	public DataImportService(ReportService reportService, CountryService countryService, RestService restService) {
		this.reportService = reportService;
		this.countryService = countryService;
		this.restService = restService;
	}

	public void importReportsByCountryTotal(String countryName) {

		reportService.saveAll(restService.invokeGetForCountry(countryName));
	}
	
	public void importCountries() {
		countryService.saveAll(restService.invokeGetForListOfCountries());
	}

}
