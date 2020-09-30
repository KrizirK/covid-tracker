package com.learning.covidtracker.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.covidtracker.domain.GlobalDataSet;

@Repository
public interface GlobalDataSetRepository extends JpaRepository<GlobalDataSet, Long> {

}
