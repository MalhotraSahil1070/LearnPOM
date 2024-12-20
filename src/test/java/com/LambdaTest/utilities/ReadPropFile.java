package com.LambdaTest.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
	
Properties prop;
	
	String filePath = "C:\\Selenium\\LearnPOM\\src\\test\\resources\\Configs\\Configurations.properties";
	
	public ReadPropFile() throws IOException
	
	{
		prop = new Properties();
		
		FileReader FR = new FileReader(filePath);
			
		prop.load(FR);
			
	}
	
	public String getURL()
	{
		return prop.getProperty("URL");
		 
	}
	
	

}
