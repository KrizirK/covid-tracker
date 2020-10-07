package com.learning.covidtracker.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.covidtracker.domain.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

	public List<Report> findAllByCountryName(String name);

}
