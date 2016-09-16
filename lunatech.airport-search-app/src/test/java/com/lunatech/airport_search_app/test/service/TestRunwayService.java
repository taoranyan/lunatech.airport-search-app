package com.lunatech.airport_search_app.test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lunatech.airport_search_app.dao.AirportDAO;
import com.lunatech.airport_search_app.dao.RunwayDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;
import com.lunatech.airport_search_app.service.RunwayService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:airport-search-app-application-context.xml")
public class TestRunwayService {
	
	@Autowired
	private RunwayService rserv;
	
	@Autowired
	private AirportDAO adao; 
	
	@Autowired
	private RunwayDAO rdao;
	
	@Before
	public void setup()
	{
		
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
		r1.setAirport(a1);
		
		Runway r2 = new Runway();
		r2.setId(3002);
		r2.setAirportRef(2001);
		r2.setAirportIdent("Test2001");
		r2.setAirport(a1);
		
		rdao.save(r1);
		rdao.save(r2);
		
	}
	
	@Test
	public void TestGetRunwaysByAirportId()
	{
		Integer id = 2001;
		List<Runway> runways = rserv.getRunwaysByAirportId(id);
		assertEquals(runways.size(), 2);
	}
	
	@Test
	public void TestGetRunwaysByAirport()
	{
		Airport airport = adao.getAirportById(2001);
		List<Runway> runways = rserv.getRunwaysByAirport(airport);
		assertEquals(runways.size(), 2);
	}
	

	@Test
	public void TestGetALlRunways(){
		List<Runway> runways = rserv.getAllRunway();
		assertEquals(runways.size(), 2);
	}
	
	
	
	@Test
	public void TestDumpRunwayFromCSV(){
		
	}
	
	@Test
	public void deleteMocks()
	{
		Airport a1 = adao.getAirportById(2001);
		Runway 	r1 = rdao.getRunwayById(3001);
		Runway 	r2 = rdao.getRunwayById(3002);
		adao.delete(a1);
		rdao.delete(r1);
		rdao.delete(r2);
	}
}
