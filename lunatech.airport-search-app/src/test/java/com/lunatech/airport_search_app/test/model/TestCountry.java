package com.lunatech.airport_search_app.test.model;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lunatech.airport_search_app.model.Country;

public class TestCountry {
	
	@Test
	public void setIdTest()
	{
		Country country = new Country();
		Integer id = 900102;
		country.setId(id);
		assertEquals(country.getId(),id);
	}
	
	@Test
	public void setCodeTest()
	{
		Country country = new Country();
		String code = "TY";
		country.setCode(code);
		assertEquals(country.getCode(), code);
	}
	
	@Test
	public void setNameTest()
	{
		Country country = new Country();
		String name = "Avacyn";
		country.setName(name);
		assertEquals(country.getName(), name);
	}
	
	@Test
	public void setContinentTest()
	{
		Country country = new Country();
		String continent = "Grenoble";
		country.setContinent(continent);
		assertEquals(country.getContinent(), continent);
	}
	
	@Test
	public void setWikiLinkTest()
	{
		Country country = new Country();
		String wiki_link = "www.wikipedia.com/avacyn";
		country.setWikiLink(wiki_link);
		assertEquals(country.getWikiLink(), wiki_link);
	}
	
	@Test
	public void setKeywordsTest()
	{
		Country country = new Country();
		String keywords = "key";
		country.setKeywords(keywords);
		assertEquals(country.getKeywords(), keywords);
	}

}