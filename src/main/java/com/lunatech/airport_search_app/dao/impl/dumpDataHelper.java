package com.lunatech.airport_search_app.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class dumpDataHelper {

	public Iterable<CSVRecord> getReaderFromFile(String filename) throws FileNotFoundException{
		
		Resource resource = new ClassPathResource("/raw-data/"+filename);
		File file = null;
		try {
			file = resource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reader in = null;
		try {
			in = new FileReader(file);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.EXCEL.withHeader().parse(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	}
}
