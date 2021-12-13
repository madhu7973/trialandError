package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToBag {
	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	WebDriver driver;

	@Test
	public void addToBag() throws InterruptedException {
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]"))
				.sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123$");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//img[@alt = 'Wish List']")).click();
		List<WebElement> addToCartButton = driver.findElements(By.id("add-to-cart"));

		int y = 5;

		for (int i = 0; i < addToCartButton.size(); i++) {
			boolean addedToBag = false;
			if (addToCartButton.get(i) == addToCartButton.get(y)) {
				addToCartButton.get(i).click();
				Thread.sleep(1500);
				addedToBag = driver.findElement(By.className("basket-confirmationsection")).isDisplayed();
				System.out.println(addedToBag);
			}
		}

	}

	@AfterMethod
	public void testDown() {
		driver.quit();
	}

}
