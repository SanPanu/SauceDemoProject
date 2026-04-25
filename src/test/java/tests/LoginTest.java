package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
	
	@Test
	public void loginTest()
	{
		LoginPage loginpage=new LoginPage(driver);
		Assert.assertTrue(loginpage.isLoginPageLogoDisplayed(),"Login Page logo is not displayed.");
		AssertJUnit.assertEquals(loginpage.getLoginPageText(), "Swag Labs");
		loginpage.login("standard_user","secret_sauce");
	
	}
	@Test
	public void loginWithInvalidCredentials()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("user1","pass1");
		Assert.assertTrue(loginpage.isErrormessageDisplayed(), "Error Message is not displayed for Invalid Credetials");
		AssertJUnit.assertEquals(loginpage.errorMessage(), "Epic sadface: Username and password do not match any user in this service");
	}

	
	
}
