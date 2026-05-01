package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentTestManager;

public class LoginTest extends BaseTest
{
	
	@Test
	public void loginWithValidCredentials()
	{
		ExtentTestManager.getTest().info("Navigating to login page");
		LoginPage loginpage=new LoginPage(driver);
		ExtentTestManager.getTest().info("Verifying login logo is displayed");
		Assert.assertTrue(loginpage.isLoginPageLogoDisplayed(),"Login Page logo is not displayed.");
		AssertJUnit.assertEquals(loginpage.getLoginPageText(), "Swag Labs");
		ExtentTestManager.getTest().info("Logging in with valid credentials");
		loginpage.login("standard_user","secret_sauce");
		ExtentTestManager.getTest().pass("Login successful");
	
	}
	@Test
	public void loginWithInvalidCredentials()
	{
		LoginPage loginpage=new LoginPage(driver);
		ExtentTestManager.getTest().info("Logging in with Invalid credentials");
		loginpage.login("user1","pass1");
		ExtentTestManager.getTest().info("Verifying error is displayed");
		Assert.assertTrue(loginpage.isErrormessageDisplayed(), "Error Message is not displayed for Invalid Credetials");
		Assert.assertEquals(loginpage.errorMessage(), "Epic sadface: Username and password do not match any user in this service");
		ExtentTestManager.getTest().pass("Username and password do not match any user in this service");
	}
	
	@Test
	public void loginWithLockedOutUser()
	{
		LoginPage loginpage=new LoginPage(driver);
		ExtentTestManager.getTest().info("Logging in with Locked credentials");
		loginpage.login("locked_out_user","secret_sauce");
		Assert.assertEquals(loginpage.errorMessage(), "Epic sadface: Sorry, this user has been locked out.");
		ExtentTestManager.getTest().info("Sorry, this user has been locked out.");
	}

	
	
}
