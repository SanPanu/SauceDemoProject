package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private static Properties properties;
	private static FileInputStream fis;
	static {
	
	String CONFIG_PATH="/Users/sangamesh/eclipse-workspace/SauceDemoProject1/src/test/resources/config.properties";
	
	try {
		fis = new FileInputStream(CONFIG_PATH);
		properties=new Properties();
		properties.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
	}
	 public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
}
