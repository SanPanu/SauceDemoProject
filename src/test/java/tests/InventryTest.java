package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ExcelUtil;

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
	@Test
	public void testDropdownContent()
	{
		 ExcelUtil excel = new ExcelUtil("InventoryPageData");
		 List<WebElement> dropdownValues = inventrypage.dropdownContents();
		 
		 int excelStartRow = 7; // FilterContents data starts at row 8
		 
		 for(int i=0;i<dropdownValues.size();i++)
		 {
			 String actual   = dropdownValues.get(i).getText().trim();
			   String expected = excel.getCellData(excelStartRow+i, 1); //col 1 = Name(A to Z) etc.
			 
		        Assert.assertEquals(
		        		actual,
		                expected,
		                "Mismatch in dropdown value at index: " + i
		        );
		 }
		
	}
	
	
	

}
