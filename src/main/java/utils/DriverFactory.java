package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	
	
	private static ThreadLocal<WebDriver> ldriver=new ThreadLocal<>();

	public static WebDriver initDriver(String browser, boolean headless)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			ldriver.set(driver);
		}	
		return getDriver();
		
	}
	
	 public static WebDriver getDriver() {
	        return ldriver.get();
	    }
	 
	 public static void quitDriver() {
		 ldriver.get().quit();
		 ldriver.remove();
	    }

}
