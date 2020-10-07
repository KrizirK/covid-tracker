package com.learning.covidtracker.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.learning.covidtracker.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
