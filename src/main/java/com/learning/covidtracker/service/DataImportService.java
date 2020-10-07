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
	private final RestService restService;

	@Autowired
	public DataImportService(ReportService countryService, RestService restService) {
		this.reportService = countryService;
		this.restService = restService;
	}

	public void importDataByCountryTotal(String countryName) {

		reportService.saveAll(restService.invokeGetFromCountry(countryName));
	}

}
