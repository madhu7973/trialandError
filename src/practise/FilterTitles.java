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

public class FilterTitles {

	@BeforeMethod
	public void openEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}

	static WebDriver driver;

	@Test
	static public void getFilterTitles()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List <WebElement> filterTitles = driver.findElements(By.xpath("//span[@class='regular-arrow' or @class='flipped-arrow']"));
		int filterTitlesCount = filterTitles.size();
		for (int i=0; i<filterTitlesCount; i++ )
		{
			String filterTitle = filterTitles.get(i).getText();
			System.out.println(filterTitle);
		}
	}

}
