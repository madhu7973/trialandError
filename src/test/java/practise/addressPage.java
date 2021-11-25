package practise;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class addressPage 
{
	WebDriver driver;

	static
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
	}

	@Test
	public void makeDefaultAddress()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123!");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//span[text() = 'Addresses']")).click();
		String address = driver.findElement(By.xpath("(//li[@class = 'top'])[1]")).getText();
		System.out.println(address);
		if (address.contains("Default Address"))
			//Assert.assertTrue(true, "default address selected");
			System.out.println("default address selected");
		else //Assert.assertFalse(false, "default address not selected");
			System.out.println("Default address not selected");
		driver.close();
	}

}
