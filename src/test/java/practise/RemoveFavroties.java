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

public class RemoveFavroties 
{

	@BeforeMethod
	public void openEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
		
	}
	
	WebDriver driver;

	@Test
	public void selectCardType()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123$");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//img[@alt = 'Wish List']")).click();

		List <WebElement> prodImages = driver.findElements(By.xpath("//tr/td[@class = 'item-image']"));
		int totalProdImages =  prodImages.size();

		if (totalProdImages > 0)
		{
			for (int i=0; i<totalProdImages; i++)
				driver.findElement(By.xpath("//button[@class = 'button-text delete-item']")).click();

			if(driver.findElement(By.className("emptywishlisttext")).isDisplayed())
			{
				String emptyMessage = driver.findElement(By.className("emptywishlisttext")).getText();
				System.out.println(emptyMessage);
			}
		}
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}
}
