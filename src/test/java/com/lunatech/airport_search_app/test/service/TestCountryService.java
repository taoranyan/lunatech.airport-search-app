package com.lunatech.airport_search_app.test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.model.Country;
import com.lunatech.airport_search_app.service.CountryService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestCountryService {
	
	@Autowired
	private CountryService cserv;
	
	@Autowired
	private CountryDAO cdao;
	
	@Before
	public void setup() {
		Country c1 = new Country();
		c1.setId(1001);
		c1.setCode("CHINA");
		c1.setName("TestCountryService1");
		cdao.save(c1);
	}
	
	
	@Test
	public void TestGetCountryById()
	{
		Integer id = 1001;
		Country c1 = cserv.getCountryById(id);
		assertEquals(c1.getId(), id);
	}
	
	
	@Test
	public void TestGetCountryByCode()
	{
		String code = "CHINA";
		Country c1 = cserv.getCountryByCode(code);
		assertEquals(c1.getCode(), code);
	}
	
	@Test
	public void TestGetCountryByName()
	{
		String name = "TestCountryService1";
		Country c1 = cserv.getCountryByName(name);
		assertEquals(c1.getName(), name);
	}
	
	@Test
	public void TestGetAllCountries(){
		
		List<Country> countries = cserv.getAllCountries();
		assertEquals(countries.size(), 1);
	}
	
	
	@Test
	public void TestDumpCountryFromCSV(){}
	
	
	@After
	public void deleteMocks()
	{
		Country c1 = cdao.getCountryById(1001);
		cdao.delete(c1);
	}
	
}
