package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class InventryTest extends BaseTest
{
	
	LoginPage loginpage;
	InventoryPage inventrypage;
	
	
	@BeforeMethod
	public void setUp()
	{
		loginpage=new LoginPage(driver);
	    inventrypage=new InventoryPage(driver);
		loginpage.login("standard_user","secret_sauce");
	}
	
	@Test
	public void testPresenceOfHamBurgerButton()
	{
		
		Assert.assertTrue(inventrypage.presenceOfHamBurgerButton(), "HamBurger Menu is not present");
	}
	@Test
	public void testIsHambergerMenuOpen()
	{
		
		Assert.assertTrue(inventrypage.isHambergerMenuOpen(), "HamBurger Menu is not Open");
	}
	@Test
	public void testClickOnAllItemsLink()
	{
		inventrypage.openHambergerMenu();
		inventrypage.clickOnAllItemsLink();
	}
	@Test
	public void testAboutPageredirect()
	{
		inventrypage.openHambergerMenu();
		inventrypage.clickAllAboutLink();
	}
	

}
