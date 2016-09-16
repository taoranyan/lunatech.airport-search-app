package com.lunatech.airport_search_app.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lunatech.airport_search_app.model.Airport;

public class TestAirport {
	/*
	"id","ident","type","name",
	"latitude_deg","longitude_deg","elevation_ft","continent","iso_country","iso_region","municipality",
	*/
	@Test
	public void setIdTest()
	{
		Airport airport = new Airport();
		Integer id = 900102;
		airport.setId(id);
		assertEquals(airport.getId(),id);
	}
	
	@Test
	public void setIdentTest()
	{
		Airport airport = new Airport();
		String ident = "Airport_TY";
		airport.setIdent(ident);
		assertEquals(airport.getIdent(), ident);
	}
	
}
