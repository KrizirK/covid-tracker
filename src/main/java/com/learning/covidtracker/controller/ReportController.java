package com.learning.covidtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.covidtracker.service.ReportService;

@Controller
public class ReportController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final ReportService countryCaseService;

	@Autowired
	public ReportController(ReportService countryService) {
		this.countryCaseService = countryService;
	}

	@RequestMapping("/reports/summary")
	public String getReports(Model model) {

		log.info("Loading summary of countries");
		model.addAttribute("reports", countryCaseService.findAll());
		log.info("Showing summary of countries");

		return "reports/list";
	}

	@RequestMapping("/reports")
	public String getReport(@RequestParam(name = "name") String countryName, Model model) {

		log.info("Loading summary of country: " + countryName);
		model.addAttribute("reports", countryCaseService.findAllByName(countryName));
		log.info("Showing summary of country: " + countryName);

		return "reports/list";
	}

}
