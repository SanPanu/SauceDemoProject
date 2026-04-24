package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
	
	@Test
	public void loginWithValidCredentials()
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
		loginpage.login("WrongUser","WrongPassword");
		Assert.assertTrue(loginpage.isErrormessageDisplayed(), "Error Message is not displayed for Invalid Credetials");
		Assert.assertEquals(loginpage.errorMessage(), "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void loginWithLockedOutUser()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("locked_out_user","secret_sauce");
		AssertJUnit.assertEquals(loginpage.errorMessage(), "Epic sadface: Sorry, this user has been locked out.");
	}

	
	
}
