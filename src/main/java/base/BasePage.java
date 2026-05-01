package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;



public class BasePage 
{
	protected WebDriver driver;
	 protected WebDriverWait wait;
	 
	 public BasePage(WebDriver driver)
	 {
		 this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicitwait"))));
	 }
	 
	 public void click(By locator)
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	 }
	 
	 public void type(By locator,String text)
	 {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
		 
	 }
	 
	 public String getText(By locator)
	 {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	 }
	 
	 public boolean isDisplayed(By locator)
	 {
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	 }
	 
}
