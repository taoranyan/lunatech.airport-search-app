package com.lunatech.airport_search_app.web;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;
import com.lunatech.airport_search_app.service.DumpDataService;
import com.lunatech.airport_search_app.service.QueryService;

public class App {
	
	public static void main(String[]args) throws FileNotFoundException{
		
		

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/airport-search-app-application-context.xml");
		
		DumpDataService dserv = ctx.getBean(DumpDataService.class);
		dserv.dumpDataFromCSV();
		
		QueryService qserv = ctx.getBean(QueryService.class);

	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	    
		while(true)
		{
			System.out.println("*****************************************************");
			System.out.println("Enter Country Code, press 1; Country Name, press 2 ..");
			System.out.println("*****************************************************");

		    String choice = scanner.next();
		    
		    String input;
		    
		    CountryAirportsRunwaysData res;
		    
		    switch(choice)
		    {
		    	case "1":	System.out.println("*****************************************************");
		    				System.out.println("          Enter country code : "); 
		    				System.out.println("*****************************************************");
		    				input = scanner.next();
		    				res = qserv.getAirportsRunwaysByCountryCode(input);
		    				res.print();
		    				break;
		    	
		    	case "2": 	System.out.println("*****************************************************");
		    				System.out.println("           Enter country name : "); 
		    				System.out.println("*****************************************************");
							input = scanner.next();
							res = qserv.getAirportsRunwaysByCountryName(input);
							res.print();
							break;
		    	
		    	default: System.out.println("[ERROR] Either enter 1 or 2 please.");
		    			break;
		    }
			
			
			
		}		
	}
	
}


