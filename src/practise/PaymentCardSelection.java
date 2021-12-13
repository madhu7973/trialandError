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

public class PaymentCardSelection {
	
	@BeforeMethod
	public void setEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
	}

	WebDriver driver;

	@Test
	public void selectCardType() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123$");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//span[text()= 'Payment Settings']")).click();
		driver.findElement(By.xpath("//a[@title= 'ADD A CREDIT CARD']")).click();
//		driver.findElement(By.xpath("//input[@id='card_type_001']")).click();
//		Thread.sleep(1000);
		
		List <WebElement> cardTypes = driver.findElements(By.xpath("//input[@name='card_type']"));
		int numberOfCardTypes = cardTypes.size();
		
		for(int i=0; i<numberOfCardTypes; i++)
		{
			String cardName = cardTypes.get(i).getText();
			System.out.println(cardName);
			if(cardName.equalsIgnoreCase("Mastercard"))
			{
				cardTypes.get(i).click();
				Thread.sleep(1000);
				System.out.println("clicked on MC option");
				break;
			}
			
		}
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}
