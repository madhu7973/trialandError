package practise;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clickMegaNavLinks.actionsClass;

public class filterPassedProducts {
	
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
	public void products() throws InterruptedException
	{
		String filterName = driver.findElement(By.xpath("//a[@title='Refine by: Ardell']")).getText();
		driver.findElement(By.xpath("//a[@title='Refine by: Ardell']")).click();
		WebElement element = driver.findElement(By.id("grid-paging-footer"));
		Select select = new Select (element);
		select.selectByVisibleText("View ALL Products");
		Thread.sleep(50000);
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}
