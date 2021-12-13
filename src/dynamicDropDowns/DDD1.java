package dynamicDropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DDD1 {

	WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}



	@BeforeMethod
	public void openEnvi()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void ddd() throws InterruptedException
	{
		int productNumber = 0;
		int filterProductsNumber = 0;

		List <WebElement> filterOptions = driver.findElements(By.xpath("//div[@class='refinement Brand']/ul/li/a"));

		for(int i=0; i<filterOptions.size(); i++)
		{
			if (filterOptions.get(i).getText().contains("Ardell"))
			{
				filterOptions.get(i).click();
				Thread.sleep(3500);
				WebElement selectedFilter = driver.findElement(By.xpath("//li[@class='selected']"));
				String filterNumber = selectedFilter.getText().replaceAll("[^0-9]", "");
				System.out.println(filterNumber);				
				filterProductsNumber = Integer.parseInt(filterNumber);
				System.out.println(filterProductsNumber);
				break;
			}
			else System.out.println("select class not displayed");
		}
		
		WebElement element = driver.findElement(By.id("grid-paging-footer"));
		Select select = new Select (element);
		select.selectByVisibleText("View ALL Products");
		Thread.sleep(50000);

		List <WebElement> products = driver.findElements(By.xpath("//div[@id='products-tab']//a[@class='name-link']"));
		productNumber = products.size();
		System.out.println(productNumber);

	}


	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}
