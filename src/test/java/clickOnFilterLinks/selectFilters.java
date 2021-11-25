package clickOnFilterLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class selectFilters extends baseCalss {

	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}

	//baseCalss base = new baseCalss();

	@BeforeMethod
	public void setEnvi()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void clickFilters() throws InterruptedException
	{
		//WebElement elementx = driver.findElement(By.xpath("//div[@class='refinement Brand']//a[@title='Refine by: Ardell']"));
		String name = baseCalss.filterOptionsClick("Ardell (167)");
		System.out.println(name);
//		if (name.equalsIgnoreCase("Ardell (167)"))
//			Assert.assertTrue(true);	
//		else Assert.fail();

	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}


}
