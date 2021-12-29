import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test extends Base {
	
	HomePage homePage;
	ProductsPage productsPage;
	ProductDetailPage productDetailPage;
	CartPage cartPage;

	@Test
	@Order(1)
	public void isOnHomePage() {
		homePage=new HomePage(driver);
		List <WebElement> elementOption = driver.findElements(By.cssSelector("span[class='o-header__userInfo--text']"));
		Assertions.assertFalse(homePage.isDisplayed(elementOption),"Ana sayfaya gidilemedi");
	}
	
	@Test
	@Order(2)
	public void searchAProduct() {
		homePage=new HomePage(driver);
		homePage.searchBox().search("pantolon");
		productsPage=new ProductsPage(driver);
		Assertions.assertTrue(productsPage.isOnProductPage(),"Pantolon sayfasına gidilemedi");
		
	}
	
	
	@Test
	@Order(3)
	public void scrollDownAndClick() {
		homePage.ScrollAndClick();
		
	}
	
	
	@Test
	@Order(4)
	public void selectTheProduct() {
		
		productDetailPage=new ProductDetailPage(driver);
		productsPage.selectProduct(1);
		
		Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Pantolon sayfasına gidilemedi");
		
	}
	
	@Test
	@Order(5)
	public void addToCart() {
		ProductDetailPage.addToCart();
		Assertions.assertTrue(homePage.isProductCountUp(), "Sepete ürün eklenmedi");
		
	}
	
	@Test
	@Order(6)
	public void checkAmount() {
		System.out.println(driver.findElement(By.cssSelector("span[class='m-orderSummary__value']" +"ürünün fiyatı")).getText());
		
	}
	
	@Test
	@Order(7)
	public void removeProduct() {
		driver.findElement(By.cssSelector("button[id='removeCartItemBtn0']")).click();
		driver.findElement(By.cssSelector("button[id='removeCartItemBtn0']")).click();
	}
	
	
	@Test
	@Order(8)
	public void CheckTheCart() {
		cartPage=new CartPage(driver);
		homePage.goToChart();
		Assertions.assertTrue(cartPage.checkIfProductAdded(), "Sepet boş");
		
	}
}
