package com.learning.covidtracker.runner;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.learning.covidtracker.dto.CountryDto;
import com.learning.covidtracker.service.CountryService;
import com.learning.covidtracker.service.TimeService;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CovidTrackerDataDownloadRunner implements CommandLineRunner {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final TimeService timeService;

	private final CountryService countryService;

	@Autowired
	public CovidTrackerDataDownloadRunner(TimeService timeService, CountryService countryService) {
		this.timeService = timeService;
		this.countryService = countryService;
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		log.info("Request for /summary/poland");
		LocalTime pre = timeService.now();
		CountryDto[] countries = restTemplate.getForObject("https://api.covid19api.com/total/country/poland",
				CountryDto[].class);

		log.info("Finished request for /summary/poland in " + Duration.between(pre, timeService.now()).toMillis()
				+ " ms");

		List<CountryDto> countriesDTO = Arrays.asList(countries);

		countryService.saveAll(countriesDTO);

	}

}
