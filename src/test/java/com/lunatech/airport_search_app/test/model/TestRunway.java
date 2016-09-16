package com.lunatech.airport_search_app.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lunatech.airport_search_app.model.Runway;

public class TestRunway {
	/*
	"id","airport_ref","airport_ident",
	*/
	@Test
	public void setIdTest()
	{
		Runway runway = new Runway();
		Integer id = 900102;
		runway.setId(id);
		assertEquals(runway.getId(),id);
	}
	
	
}
