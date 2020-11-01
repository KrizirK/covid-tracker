package com.learning.covidtracker.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ActiveProfiles;

import com.learning.covidtracker.domain.repository.CountryRepositoryTest;
import com.learning.covidtracker.domain.repository.ReportRepositoryTest;
import com.learning.covidtracker.dto.mapper.CountryMapperTest;
import com.learning.covidtracker.dto.mapper.ReportMapperTest;

@RunWith(Suite.class)
@SuiteClasses({ //
		CountryRepositoryTest.class, //
		ReportRepositoryTest.class, //
		//
		CountryMapperTest.class, //
		ReportMapperTest.class,//
})
@ActiveProfiles("test")
public class CovidTrackerMainTestSuite {
	

}
