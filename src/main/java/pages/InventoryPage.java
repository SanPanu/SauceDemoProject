package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class InventoryPage extends BasePage
{

	public InventoryPage(WebDriver driver) {
		super(driver);
		
	}
	private By HamburgerMenuButton=By.xpath("//button[@id='react-burger-menu-btn']");
	private By HamburgerMenuList=By.xpath("//nav[@class='bm-item-list']//a");
	private By AllItemsLink=By.id("inventory_sidebar_link");
	private By AllAboutLink=By.id("about_sidebar_link");
	private By logoutLink=By.id("logout_sidebar_link");
	private By HamburgerIconCloseBtn=By.xpath("//div[@class='bm-cross-button']");
	private By slectDropdown=By.xpath("//select[@class='product_sort_container']");
	private By DropDownOptions=By.xpath("//select[@class='product_sort_container']/option");
	private By cartLink=By.id("shopping_cart_container");
	private By inventrycards=By.xpath("//div[@class='inventory_item']");
	private By invenryLabel=By.xpath("//div[@class='inventory_item_label']//a");
	private By invetryPriceBar=By.xpath("//div[@class='inventory_item_price']");
	private By inventrycartButton=By.xpath("//div[@class='inventory_item_description']//button");
	private By cartItemName=By.xpath("//div[@class='cart_item']//a");
	
	
	
	public List<String> getProductNames()
	{
		List<WebElement> elements = driver.findElements(invenryLabel);
		
		ArrayList<String> names=new ArrayList<>();
		
		for(WebElement e:elements)
		{
			names.add(e.getText().trim());
		}
		return names;
		
	}
	
	
	
	
	
	public void selectSortingOption(String option)
	{
		Select dropdown= new Select(driver.findElement(slectDropdown));
		dropdown.selectByVisibleText(option);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invenryLabel));
		
	}
	
	public boolean presenceOfHamBurgerButton()
	{
		return isDisplayed(HamburgerMenuButton);
	}
	public void openHambergerMenu()
	{
		click(HamburgerMenuButton);
		isDisplayed(HamburgerIconCloseBtn);
	}
	public boolean isHambergerMenuOpen()
	{
		return driver.findElements(HamburgerMenuList).size()>0;
	}
	public void clickOnAllItemsLink()
	{
		click(AllItemsLink);
		
	}
	public void clickAllAboutLink()
	{
		click(AllAboutLink);
		
	}
	
	public void clcikOnAddToCart(String productName)
	{
		List<WebElement> productLabels = driver.findElements(invenryLabel);
		for(WebElement products:productLabels)
		{	
			if(products.getText().equalsIgnoreCase(productName))
			{
				products.findElement(inventrycartButton).click();
				break;
			}
			
			
		}
	}
	
	public void clickOnMainCartLink()
	{
		click(cartLink);
		
	}
	public boolean verifyProductInCart(String productName)
	{
		List<WebElement> items = driver.findElements(cartItemName);
		
		for(WebElement item:items)
		{
			if(item.getText().equalsIgnoreCase(productName))
			{
				return true;
			}
		}
		return false;
	}
	
	public List<WebElement> dropdownContents()
	{
		return driver.findElements(DropDownOptions);
	}

}
