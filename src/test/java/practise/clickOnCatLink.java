package practise;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clickOnCatLink {
	@BeforeMethod
	public void openEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}

	static WebDriver driver;

	@Test
	static public void getFilterTitles() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List <WebElement> catLinks = driver.findElements(By.xpath("//li[@class='expandable active' or @class ='refinement-link  active']//a"));

		for (int i=0; i<catLinks.size(); i++)
		{
			
			if (catLinks.get(i).getText().equals("Eye Makeup (198)"))
			{
				catLinks.get(i).click();
				Thread.sleep(3000);
				String pageTitle = driver.getTitle();
				System.out.println(pageTitle);
				break;
			}

		}
	}



}
