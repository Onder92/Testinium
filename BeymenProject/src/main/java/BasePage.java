import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebElement find(List<WebElement> elementOption) {
		return driver.findElements(elementOption);
	}
	
	public List<WebElement> findAll(By locator){
		return driver.findElements(locator);
	}
	
	public void click(By locator) {
		find(locator).click();
	}
	
	public void type(By locator, String text) {
		find(locator).sendKeys(text);
	}
	
	public Boolean isDisplayed(By homePageLocator) {
		return find(homePageLocator).isDisplayed();
	}
}
