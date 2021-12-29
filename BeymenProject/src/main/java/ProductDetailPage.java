import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
	
	By bodySize= By.cssSelector("span[class='m-variation__item -active']");
	By addToChartButtonLocator= By.id("addBasket");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isOnProductDetailPage() {
		
		return isDisplayed(addToChartButtonLocator);
	}

	public void addToCart() throws InterruptedException {
		click(bodySize);
		Thread.sleep(1000L);
		click(addToChartButtonLocator);
		
	}
	

}
