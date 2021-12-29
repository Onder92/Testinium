import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public class Base {

	WebDriver driver;
	
	@BeforeAll
	public void main (String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.beymen.com/");
		
		driver.manage().window().maximize();
	}

	@AfterAll
	public void tear(){
		driver.quit();
		
	}
}
