package com.mmdrama.core.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.mmdrama.constants.PropertyKey;

public class PropertiesFile {
	
	private static Properties prop = new Properties();
	
	public static Properties load()
	{ 
    	try {
               //load a properties file
    		
    		prop.load(new FileInputStream("/home/phyoau82/app/application.properties"));
    		
    
    	} catch (IOException ex) {
    		
    		ex.printStackTrace();
        }	
    	return prop;	
	}

	public static String getString(String key)
	{
		load();
		return prop.getProperty(key);
	}
	
	public static String getString(PropertyKey key)
	{
		load();
		return prop.getProperty(key.getName());
	}
	
	
}
