package clickMegaNavLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dummy {
	
	WebDriver driver;
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}
	
	actionsClass act = new actionsClass();
	
	@BeforeMethod
	public void setEnvi() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/beauty/makeup/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
	}
	
	@Test
	public void getText()
	{
		String name = driver.findElement(By.xpath("//div[@class='refinement Brand']//a[@title='Refine by: Ardell']")).getText();
		System.out.println(name);
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}
