package practise;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dates {

	@BeforeMethod
	public void openEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
	}

	WebDriver driver;

	@Test
	public void editItem() throws ParseException
	{
		driver = new ChromeDriver();
		driver.get("https://www.sallybeauty.com/my-account/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_username_')]")).sendKeys("madhusudan.devaraju@capgemini.com");
		driver.findElement(By.xpath("//input[contains(@id, 'dwfrm_login_password')]")).sendKeys("Madhu123$");
		driver.findElement(By.name("dwfrm_login_login")).click();
		driver.findElement(By.xpath("//img[@alt = 'Wish List']")).click();


		List <WebElement> dates = driver.findElements(By.xpath("//tr/td[@class='item-actions']"));
		int numberOfDates = dates.size();

		int z = 7;
		String appDATE = null;

		for(int i=0; i<numberOfDates; i++)
		{
			if (dates.get(i)== dates.get(z))
			{
				String actualDate = dates.get(i).getText();
				System.out.println(actualDate);

				String dateText = actualDate;
				DateFormat fechas = new SimpleDateFormat("MMMMM dd, yyyy");
				try {
					Date parse = fechas.parse(dateText);
					appDATE = fechas.format(parse);

				} catch (ParseException ex) {
					System.out.println("not tranformed");
				}

			}
		}

		DateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		Date date = new Date();
		String sysDate = dateFormat.format(date);
		System.out.println(sysDate);

		if (appDATE.equalsIgnoreCase(sysDate))
			System.out.println("date matched");
		else System.out.println("dates wont match");
	}
}
