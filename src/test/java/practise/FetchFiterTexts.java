package practise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FetchFiterTexts {
	
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
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.findElement(By.xpath("//div[@class='refinement Brand']//div[@id='showmorebutton']")).click();
		List <WebElement> texts = driver.findElements(By.xpath("//div[@class='refinement Brand']/ul/li/a"));
		for (WebElement s: texts)
		{
			String atext = s.getText();
			String extract = atext.replaceAll("[^a-zA-Z]+", "");
			System.out.println(extract);
		}
			
		driver.close();
	}

}
