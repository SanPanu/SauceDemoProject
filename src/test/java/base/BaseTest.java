package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest 
{
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser","headless"})
	public void setUp(@Optional("chrome")String browser,
			@Optional("false") String headless)
	{	
		//initialize Browser
		driver=DriverFactory.initDriver(browser,Boolean.parseBoolean(ConfigReader.getProperty(headless)));
		String url=ConfigReader.getProperty("baseUrl");
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	 @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
    

}
