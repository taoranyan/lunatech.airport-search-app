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
import com.lunatech.airport_search_app.dao.RunwayDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;
import com.lunatech.airport_search_app.model.Runway;
//import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestRunwayDAO {

	@Autowired
	private CountryDAO cdao;
	
	@Autowired
	private AirportDAO adao;
	
	@Autowired
	private RunwayDAO rdao;

	@Before
	public void setup(){
		
		Country c1 = new Country();
		c1.setId(1001);
		c1.setCode("CHINA");
		c1.setName("TestCountryDAO1");
		cdao.save(c1);
		
		Airport a1 = new Airport();
		a1.setId(2001);
		a1.setIdent("Test2001");
		a1.setName("TestAirportDAO1");
		a1.setIsoCountry("CHINA");
		
		adao.save(a1);
		
		Runway r1 = new Runway();
		r1.setId(3001);
		r1.setAirportRef(2001);
		r1.setAirportIdent("Test2001");
		r1.setSurface("TestSurface1");
		//r1.setAirport(a1);
		
		Runway r2 = new Runway();
		r2.setId(3002);
		r2.setAirportRef(2001);
		r2.setAirportIdent("Test2001");
		r2.setSurface("TestSurface2");
		//r2.setAirport(a1);
		
		rdao.save(r1);
		rdao.save(r2);
		
	}
	
	
	@Test
	public void TestGetRunwaysByAirport() {

		Airport airport = adao.getAirportById(2001);
		List<Runway> runways = rdao.getRunwaysByAirport(airport);
		assertEquals(runways.size(), 2);
	}
	
	@Test
	public void TestGetRunwayByAirportId() {
		
		List<Runway> runways = rdao.getRunwayByAirportId(2001);
		assertEquals(runways.size(), 2);
	}
	
	@Test
	public void TestGetRunwayByCountryCode() {
		List<Runway> runways = rdao.getRunwayByCountryCode("CHINA");
		assertEquals(runways.size(), 2);
		assertEquals(runways.get(0).getSurface(), "TestSurface1");
		assertEquals(runways.get(1).getSurface(), "TestSurface2");
		
	}
	
	@Test
	public void TestGetRunwayByCountryName() {
		List<Runway> runways = rdao.getRunwayByCountryName("TestCountryDAO1");
		assertEquals(runways.size(), 2);
		assertEquals(runways.get(0).getSurface(), "TestSurface1");
		assertEquals(runways.get(1).getSurface(), "TestSurface2");
		
	}
	
	/*
	@Test
	public void TestGetAirportRunwaysByCountryName(){
		
		CountryAirportsRunwaysData res = rdao.getAirportRunwaysByCountryName("TestCountryDAO1");
		//assertEquals(res.size(), 0);

	}
	*/
	@Test
	public void TestDumpRunwaysFromCSV() {
	}
	
	@After
	public void deleteAirports() {
		Runway r1 = rdao.getRunwayById(3001);
		Runway r2 = rdao.getRunwayById(3002);
		Airport a1 = adao.getAirportById(2001);

		rdao.delete(r1);
		rdao.delete(r2);
		adao.delete(a1);
	}
}
