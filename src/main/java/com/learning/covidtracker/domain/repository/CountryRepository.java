package com.learning.covidtracker.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.covidtracker.domain.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

	public List<Country> findAllByName(String name);

	public Country findByName(String name);
}
