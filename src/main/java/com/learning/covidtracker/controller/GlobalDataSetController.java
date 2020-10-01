package com.learning.covidtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.covidtracker.domain.repository.GlobalDataSetRepository;

@Controller
public class GlobalDataSetController {

	private final GlobalDataSetRepository globalDataSetRepository;

	@Autowired
	public GlobalDataSetController(GlobalDataSetRepository globalDataSetRepository) {
		this.globalDataSetRepository = globalDataSetRepository;
	}

	@RequestMapping("/global")
	public String getGlobalDataSet(Model model) {

		model.addAttribute("authors", globalDataSetRepository.findAll());

		return "globalDataSet";
	}

}
