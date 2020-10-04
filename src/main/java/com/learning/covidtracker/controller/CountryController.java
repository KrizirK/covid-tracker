package com.learning.covidtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.covidtracker.domain.repository.CountryRepository;
import com.learning.covidtracker.domain.repository.GlobalDataSetRepository;
import com.learning.covidtracker.service.CountryService;

@Controller
public class CountryController {

	private final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@RequestMapping("/country/poland")
	public String getGlobalDataSet(Model model) {

		model.addAttribute("countries", countryService.findAll());

		return "country/list";
	}

}
