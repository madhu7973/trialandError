package practise;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CardTypeSelection 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
	}

	WebDriver driver;

	@Test
	public void selectCardType()
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123!");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//span[text() = 'Account Info']")).click();	
		List <WebElement> radiobuttons = driver.findElements(By.xpath("//input[@class= 'radiobutton']"));
		for (int i=0; i< radiobuttons.size(); i++)
		{
			String radioButtonName = radiobuttons.get(i).getText();
			if (radioButtonName.equals(" Yes, I have a Sally Beauty School Card."))
			{
				radiobuttons.get(i).click();
				System.out.println(radiobuttons.get(i).getText());
				break;
			}

		}
		//driver.close();
	}

}

