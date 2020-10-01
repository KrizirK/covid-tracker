package com.learning.covidtracker.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.covidtracker.domain.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}