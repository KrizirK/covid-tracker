package com.learning.covidtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.covidtracker.service.ReportService;

@Controller
public class ReportController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final ReportService reportService;

	@Autowired
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@RequestMapping("/reports")
	public String getReports(Model model) {

		log.info("Loading summary of countries");
		model.addAttribute("reports", reportService.findAll());
		log.info("Showing summary of countries");

		return "reports/list";
	}

	@RequestMapping("/reports/{countryName}")
	public String getReport(@PathVariable(value = "countryName") String countryName, Model model) {

		log.info("Loading summary of country: " + countryName);
		model.addAttribute("reports", reportService.findAllByName(countryName));
		log.info("Showing summary of country: " + countryName);

		return "reports/list";
	}

}
