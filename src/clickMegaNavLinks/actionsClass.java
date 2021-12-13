package clickMegaNavLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClass {
	
	WebDriver driver;
	
	public String mouseHoverOnMegaNav(WebElement element1, WebElement element2) throws InterruptedException
	{
		Actions action = new Actions (driver);
		action.moveToElement(element1).build().perform();
		Thread.sleep(3000);
		//driver.findElement(By.linkText(linkName)).click();
		action.moveToElement(element2).click().build().perform();
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

}
