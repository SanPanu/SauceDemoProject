package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentReportManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

public class BaseTest 
{
	protected WebDriver driver;
	  private static ExtentReports extent;
	  
	  // ── Runs once before the entire suite ──────────────────────────────────
	    @BeforeSuite(alwaysRun = true)
	    public void initReport() {
	        extent = ExtentReportManager.getInstance();
	    }

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser","headless"})
	public void setUp(@Optional("chrome")String browser,
			@Optional("false") String headless, ITestResult result)
	{	
		//initialize Browser
		driver=DriverFactory.initDriver(browser,Boolean.parseBoolean(ConfigReader.getProperty(headless)));
		String url=ConfigReader.getProperty("baseUrl");
		driver.get(url);
		driver.manage().window().maximize();
		
		// Create an ExtentTest entry for this test method
        ExtentTest test = extent.createTest(
                result.getMethod().getMethodName(),
                result.getMethod().getDescription()
        );
        ExtentTestManager.setTest(test);
		
	}
	
	
	 @AfterMethod(alwaysRun = true)
	    public void tearDown(ITestResult result) {
	        ExtentTest test = ExtentTestManager.getTest();

	        if (result.getStatus() == ITestResult.FAILURE) {
	            // Capture screenshot and attach to report
	            String screenshotPath = ScreenshotUtil.takeScreenshot(
	                    DriverFactory.getDriver(),
	                    result.getMethod().getMethodName()
	            );
	            test.fail(result.getThrowable(),
	                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.skip(result.getThrowable());

	        } else {
	            test.pass("Test passed successfully");
	        }

	        ExtentTestManager.removeTest();
	        DriverFactory.quitDriver();
	    }

	 @AfterSuite(alwaysRun = true)
	    public void flushReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

}
