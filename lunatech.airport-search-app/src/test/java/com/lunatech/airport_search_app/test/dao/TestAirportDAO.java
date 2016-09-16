package com.lunatech.airport_search_app.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lunatech.airport_search_app.dao.AirportDAO;
import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestAirportDAO {

	@Autowired
	private AirportDAO adao;
	
	@Autowired
	private CountryDAO cdao;

	@Before
	public void setup(){
		
		Country c1 = new Country();
		c1.setId(1001);
		c1.setCode("CHINA");
		c1.setName("Cathiec");
		cdao.save(c1);
		
		Airport a1 = new Airport();
		a1.setId(2001);
		a1.setIdent("Test2001");
		a1.setName("TestAirportDAO1");
		a1.setIsoCountry("CHINA");
		//a1.setCountry(null);

		Airport a2 = new Airport();
		a2.setId(2002);
		a2.setIdent("Test2002");
		a2.setName("TestAirportDAO2");
		a2.setIsoCountry("CHINA");
		//a2.setCountry(null);
		
		adao.save(a1);
		adao.save(a2);
		

		
	}
	
	@Test
	public void TestGetAirportById() {
		Integer id = 2001;
		Airport airport = adao.getAirportById(id);
		assertEquals(airport.getId(), id);
	}
	
	
	@Test
	public void TestGetAirportsByCountry() {
		
		Country c1 = cdao.getCountryById(1001);
		List<Airport> airports = adao.getAirportsByCountry(c1);
		assertEquals(airports.size(), 2);
	}
	
	@Test
	public void TestGetAirportsByCountryCode() {
		String code = "CHINA";
		List<Airport> airports = adao.getAirportsByCountryCode(code);
		assertEquals(airports.size(), 2);
	}
	
	@Test
	public void TestGetAirportsByCountryName() {

		String name = "Cathiec";
		List<Airport> airports = adao.getAirportsByCountryName(name);
		assertEquals(airports.size(), 2);
	}
	
	@Test
	public void TestDumpCountriesFromCSV() {
	}
	
	@After
	public void deleteAirports() {
		Airport a1 = adao.getAirportById(2001);
		Airport a2 = adao.getAirportById(2002);
		Country c1 = cdao.getCountryById(1001);
		adao.delete(a1);
		adao.delete(a2);
		cdao.delete(c1);
	}
}
