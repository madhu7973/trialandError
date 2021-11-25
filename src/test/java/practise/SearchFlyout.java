package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlyout {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		boolean b = flyout();
		System.out.println(b);
		Thread.sleep(1000);
		driver.quit();
	}

	public static boolean flyout() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.loreal-paris.fr/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='close-button']")).click();
		driver.findElement(By.xpath("//button[@title='Fermer']")).click();

		driver.findElement(By.id("search-text")).sendKeys("sha");
		String exception = "";
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement sSFlyout = driver.findElement(By.xpath("(//div[@class = 'main-bottom-holder'])[2]"));
//		try {
//			wait.until(ExpectedConditions.visibilityOf(sSFlyout));
//		} catch (TimeoutException e) {
//
//			/*
//			 * By using this method, we will only get name and description of an exception.
//			 * Note that this method is overridden in Throwable class.
//			 */
//			exception = e.toString();
//			System.out.println(exception);
//		}
//
//		if (exception.isEmpty())
//			return true;
//		else
//			return false;
//		all the statements below the return becomes unreachable
		
		if(sSFlyout.isDisplayed())
			return true;
		else return false;
	}

}
