package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage
{
		
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By uname=By.id("user-name");
	private By pass=By.id("password");
	private By homePageLogo=By.className("login_logo");
	private By loginButton=By.id("login-button");
	private By errormessageElement=By.xpath("//h3[@data-test='error']");
	
	public boolean isErrormessageDisplayed()
	{
		return isDisplayed(errormessageElement);
	}
	
	public String errorMessage()
	{
		return getText(errormessageElement);
	}
	
	public boolean isLoginPageLogoDisplayed()
	{
		return isDisplayed(homePageLogo);
	}
	
	public String getLoginPageText()
	{
		return getText(homePageLogo);
	}
	
	public void login(String usernames,String passwords)
	{
		
		type(uname, usernames);
		type(pass,passwords);
		click(loginButton);
	}
	

}
