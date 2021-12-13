package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MegaMenu {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.loreal-paris.fr/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//		List<WebElement> rootCatWOMM = driver.findElements(By.xpath("//li[@class='top-level  ']"));
//		for(WebElement w : rootCatWOMM)
//			System.out.println(w.getText());

//		driver.findElement(By.xpath("//div[@class='close-button']")).click();
//		driver.findElement(By.xpath("//button[@title='Fermer']")).click();

//		System.out.println("-----");

		List<WebElement> rootCatWMM = driver.findElements(By.xpath("//li[contains(@class,' has-drop')]"));
		
//		for (WebElement w : rootCatWMM) 
//			System.out.println(w.getText());

			

		String catLink = "Maquillage";

		Actions action = new Actions(driver);
		for (int i = 0; i < rootCatWMM.size(); i++) {
			if (catLink.equalsIgnoreCase(rootCatWMM.get(i).getText())) {
				System.out.println("-----------");
				System.out.println(rootCatWMM.get(i).getText());
				action.moveToElement(rootCatWMM.get(i)).perform();
				WebElement activeFlyout = driver.findElement(By.xpath("//div[contains(@class,'active_submenu')]"));
				System.out.println(activeFlyout.isDisplayed());
				Thread.sleep(2000);
				break;
			}
		}
		driver.close();
	}

}
