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

public class seeMoreLinkAfterSixFilterOptions {
	
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setEnvi()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void checkDefaultFilterOptions()
	{
		List <WebElement> defaultFilterOptions = driver.findElements(By.xpath("//div[@id='showmorebutton']//..//li[@class='' or @class = '  ']"));
		
		System.out.println(defaultFilterOptions.size());
		
		for (int i=0; i<defaultFilterOptions.size(); i++)
			System.out.println(defaultFilterOptions.get(i).getText());
		
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}
	

}
