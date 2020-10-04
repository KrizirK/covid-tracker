package com.learning.covidtracker.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class CovidTrackerRunner implements CommandLineRunner {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	public CovidTrackerRunner() {
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Up and running");
	}
}
