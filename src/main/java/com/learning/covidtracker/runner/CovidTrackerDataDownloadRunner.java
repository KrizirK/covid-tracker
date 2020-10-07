package com.learning.covidtracker.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.learning.covidtracker.service.DataImportService;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CovidTrackerDataDownloadRunner implements CommandLineRunner {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final DataImportService dataImportService;

	@Value("#{'${com.learning.runner.datadownloadrunner.list}'.split(',')}")
	private final List<String> initialCountries;

	@Autowired
	public CovidTrackerDataDownloadRunner(DataImportService dataImportService, List<String> initialCountries) {
		this.dataImportService = dataImportService;
		this.initialCountries = initialCountries;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Getting data for initial countries");

		for (String country : initialCountries) {

			log.info("Getting data for country: " + country);
			dataImportService.importDataByCountryTotal(country);
			log.info("Done getting data for country: " + country);

		}

	}

}
