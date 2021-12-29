import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
	
	By productsPageLocator= By.xpath("//*[@id=\\\"productListTitle\\\"]/b");
	By productNameLocator=By.cssSelector("div[class='m-productImageList__item']");

	public ProductsPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isOnProductPage() {
		
		return isDisplayed(productsPageLocator);
	}

	public void selectProduct(int i) {
		
		getAllProducts().get(i).click();
		
	}
	
	private List<WebElement> getAllProducts(){
		return findAll(productNameLocator);
	}

}
