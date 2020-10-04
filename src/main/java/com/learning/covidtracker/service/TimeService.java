package com.learning.covidtracker.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

	public LocalTime now() {
		return LocalTime.now();
	}
}
