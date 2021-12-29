import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
	
	SearchBox searchBox;
	By cartCountLocator= By.cssSelector("[class='o-header__userInfo--count']"); 

	public HomePage(WebDriver driver) {
		super(driver);
		searchBox=new SearchBox(driver);
		
	}
	
	public void ScrollAndClick() {
		
		JavascriptExecutor js = (JavaScriptExecutor)driver;
		js.executeScript("scrollBy(0, 3500)");
		Thread.sleep(3000);
		Actions a=new Actions(driver);
		WebElement move=driver.findElement(By.id("moreContentButton"));
		a.moveToElement(move).click().build().perform();
	}

	public SearchBox searchBox() {
		
		return this.searchBox;
	}

	public boolean isProductCountUp() {
		
		return getCartCount()==2;
	}

	public void goToChart() {
		
		click(cartCountLocator);
		
	}	
		private int getCartCount() {
			String count= find(cartCountLocator).getText();
			return Integer.parseInt(count);
		}
	}