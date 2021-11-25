package clickMegaNavLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testClass extends actionsClass{
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
	}
	
	actionsClass act = new actionsClass();
	
	@BeforeMethod
	public void setEnvi() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
	}
	
	@Test
	public void mouseHover() throws InterruptedException
	{
		WebElement element1 = driver.findElement(By.xpath("//a[@id='beauty']"));
		WebElement element2 = driver.findElement(By.xpath("(//a [@href = 'https://www.sallybeauty.com/beauty/makeup/'])[1]"));
		mouseHoverOnMegaNav(element1,element2);
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}
