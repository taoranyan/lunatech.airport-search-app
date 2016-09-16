package com.lunatech.airport_search_app.test.dao;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.model.Country;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestCountryDAO {

	@Autowired
	CountryDAO cdao;
	
	@Before
	public void setup(){
		Country c1 = new Country();
		c1.setId(1001);
		c1.setCode("Test1001");
		c1.setName("TestCountryDAO1");
		cdao.save(c1);
	}
	
	@Test
	public void TestGetCountryById() {
		Integer id = 1001;
		Country country = cdao.getCountryById(id);
		assertEquals(country.getId(), id);
	}
	
	
	@Test
	public void TestGetCountryByCode() {
		String code = "Test1001";
		Country country = cdao.getCountryByCode(code);
		assertEquals(country.getCode(), code);
	}
	
	@Test
	public void TestGetCountryByName() {
		String name = "TestCountryDAO1";
		Country country = cdao.getCountryByName(name);
		assertEquals(country.getName(), name);
	}
	
	@Test
	public void TestDumpCountriesFromCSV() {
	}
	
	@After
	public void deleteCountry() {
		Country country = cdao.getCountryById(1001);
		cdao.delete(country);
	}

}
