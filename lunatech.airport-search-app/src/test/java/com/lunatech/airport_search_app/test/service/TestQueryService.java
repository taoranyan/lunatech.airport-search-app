package com.lunatech.airport_search_app.test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

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
import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;
import com.lunatech.airport_search_app.service.QueryService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestQueryService {

	@Autowired
	QueryService qserv;
	
	@Autowired
	CountryDAO cdao;
	
	@Autowired
	AirportDAO adao;
	
	@Autowired
	RunwayDAO rdao;
	
	@Before
	public void setup() {
		
		Country c1 = new Country();
		c1.setId(1001);
		c1.setCode("CHINA");
		c1.setName("TestCountry1001");
		cdao.save(c1);
		
		Airport a1 = new Airport();
		a1.setId(2001);
		a1.setIdent("Test2001");
		a1.setName("TestAirport2001");
		a1.setIsoCountry("CHINA");

		Airport a2 = new Airport();
		a2.setId(2002);
		a2.setIdent("Test2002");
		a2.setName("TestAirport2002");
		a2.setIsoCountry("CHINA");
		
		adao.save(a1);
		adao.save(a2);
		
		Runway r1 = new Runway();
		r1.setId(3001);
		r1.setAirportRef(2001);
		r1.setAirportIdent("TestAirport2001");
		r1.setSurface("TestRunway3001");
		
		Runway r2 = new Runway();
		r2.setId(3002);
		r2.setAirportRef(2002);
		r2.setAirportIdent("TestAirport2002");
		r2.setSurface("TestRunway3002");
		
		rdao.save(r1);
		rdao.save(r2);
	}
	
	@Test
	public void TestGetAirportsRunwaysByCountryCode()
	{
		CountryAirportsRunwaysData res = qserv.getAirportsRunwaysByCountryCode("CHINA");
		Country country = res.getCountry();
		List<Airport> listAirports = res.getListAirports();
		Map<Airport, List<Runway> > mapAirportRunways = res.getMapAirportRunways();
		assertEquals(country.getCode(), "CHINA");
		assertEquals(listAirports.size(), 2);
		for(Airport a : listAirports)
		{
			assertEquals(mapAirportRunways.get(a).size(), 1);
		}
		
	}
	
	@Test
	public void TestGetAirportsRunwaysByCountryName()
	{
		CountryAirportsRunwaysData res = qserv.getAirportsRunwaysByCountryName("TestCountry1001");
		Country country = res.getCountry();
		List<Airport> listAirports = res.getListAirports();
		Map<Airport, List<Runway> > mapAirportRunways = res.getMapAirportRunways();
		assertEquals(country.getName(), "TestCountry1001");
		assertEquals(listAirports.size(), 2);
		for(Airport a : listAirports)
		{
			assertEquals(mapAirportRunways.get(a).size(), 1);
		}
	}
	
	@After
	public void deleteMocks()
	{
		Runway r1  = rdao.getRunwayById(3001);
		Runway r2  = rdao.getRunwayById(3002);
		rdao.delete(r1);
		rdao.delete(r2);
		Airport a1 = adao.getAirportById(2001);
		Airport a2 = adao.getAirportById(2002);
		adao.delete(a1);
		adao.delete(a2);
		Country c1 = cdao.getCountryById(1001);
		cdao.delete(c1);
	}
	
}
