package com.service.properties;

import java.util.Properties;

public class SimplePropertyCreator implements PropertiesCreator {
	
	private String value = "";
	private Properties prop = SinglePropertiesReader.getInstance();
	
	public String getProperty(String key){
			getPropValue(key);
		return value;
		
	}
	private void getPropValue(String key){
			value = prop.getProperty(key);
	}
	
	
}
