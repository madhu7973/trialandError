package practise;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clickEditButton {

	@BeforeMethod
	public void openEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
	}

	WebDriver driver;

	@Test
	public void editItem()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123$");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//img[@alt = 'Wish List']")).click();
		List <WebElement> editLinks = driver.findElements(By.className("editItem"));
		int totalProductImage = editLinks.size();
		int x=3;
		for (int i=0; i<totalProductImage; i++)
		{
			if(editLinks.get(i)==editLinks.get(x))	
			{
				editLinks.get(i).click();
			}
		}

		driver.close();
	}
}
