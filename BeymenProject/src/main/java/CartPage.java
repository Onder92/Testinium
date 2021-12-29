import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {
	
	
	
	By productQuantityLocator = new By.ByCssSelector("strong.m-basket__productInfoCategory");

	public CartPage(WebDriver driver) {
		super(driver);
		
		WebElement staticDropdown=driver.findElement(By.id("quantitySelect0"));
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByValue("2");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

	public boolean checkIfProductAdded() {
		return getProducts().size() > 1;
	}
	
	private List<WebElement> getProducts(){
		return findAll(productQuantityLocator);
	}
		
		
	}
}
