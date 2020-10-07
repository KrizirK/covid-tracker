package com.learning.covidtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.covidtracker.service.CountryService;
import com.learning.covidtracker.service.ReportService;

@Controller
public class CountryController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@RequestMapping("/countries")
	public String getReport(Model model) {

		log.info("Loading countries");
		model.addAttribute("countries", countryService.findAll());
		log.info("Showing countries");

		return "countries/list";
	}

}
