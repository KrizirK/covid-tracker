package com.learning.covidtracker.service.external;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.covidtracker.dto.CountryDto;
import com.learning.covidtracker.dto.ReportDto;
import com.learning.covidtracker.service.TimeService;

@Service
public class RestService {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TimeService timeService;

	@Autowired
	public RestService(TimeService timeService) {
		this.timeService = timeService;
	}

	public List<ReportDto> invokeGetForCountry(String country) {

		RestTemplate restTemplate = new RestTemplate();

		log.info("Request for /summary/" + country);

		LocalTime pre = timeService.now();
		ReportDto[] reportData = restTemplate.getForObject("https://api.covid19api.com/total/country/" + country,
				ReportDto[].class);

		log.info("Finished request for /summary/" + country + " in "
				+ Duration.between(pre, timeService.now()).toMillis() + " ms");

		return Arrays.asList(reportData);
	}

	public List<CountryDto> invokeGetForListOfCountries() {

		RestTemplate restTemplate = new RestTemplate();

		log.info("Request for /countries");

		LocalTime pre = timeService.now();
		CountryDto[] countryData = restTemplate.getForObject("https://api.covid19api.com/countries",
				CountryDto[].class);

		log.info("Finished request for /countries/" + " in " + Duration.between(pre, timeService.now()).toMillis()
				+ " ms");

		return Arrays.asList(countryData);
	}

}
