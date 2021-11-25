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

public class selectDateMonthFromDatePicker {
	
WebDriver driver;
	
	@BeforeMethod
	public void setEnvi()
	{
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\maddevar\\Softwares\\SeleniumDependencies\\BrowserExecutables\\chromedriverv-0.23.0-win64.exe");
			driver = new ChromeDriver();
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
	}
	
	@Test
	public void SelectMonth() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click();
		
		WebElement nextMonnthArrow = driver.findElement(By.xpath("(//a[@title='Next'])[1]"));
		for (int i=0; i < 6; i++)
		{
			List <WebElement> months = driver.findElements(By.xpath("//div[@class='dateFilter hasDatepicker']//div[@class='ui-datepicker-title']"
					+ "//span[@class='ui-datepicker-month']"));
			
			for (int j=0; j<months.size(); i++)
			{
				String monthName = months.get(i).getText();
				if (monthName.equalsIgnoreCase("may"))
				{
					
				}
			}
			//else nextMonnthArrow.click();
		}
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}
