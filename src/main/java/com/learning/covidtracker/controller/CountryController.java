package com.learning.covidtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.covidtracker.domain.repository.CountryRepository;
import com.learning.covidtracker.domain.repository.GlobalDataSetRepository;

@Controller
public class CountryController {

	private final CountryRepository countryRepository;

	@Autowired
	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@RequestMapping("/country/poland")
	public String getGlobalDataSet(Model model) {

		model.addAttribute("countries", countryRepository.findAll());

		return "country/list";
	}

}
