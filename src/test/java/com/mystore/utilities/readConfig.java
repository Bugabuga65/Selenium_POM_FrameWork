package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class readConfig {

	Properties properties;

	String path = "C:\\Users\\divya\\eclipse-workspace\\MyStore\\Configuration\\Config.properties";

	// constructor
	public readConfig() {
		try {

			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Get url value
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");

		if (value != null)
			return value;
		else
			throw new RuntimeException("Url not specified on config file");
	}

	//get browser value
	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null)
			return value;
		else
			throw new RuntimeException("Browser not specified on config file");
	}

}
