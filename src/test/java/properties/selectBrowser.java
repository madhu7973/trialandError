package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selectBrowser {
	public static Properties prop;
	public static WebDriver driver;

	public void sample()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Madhu\\TrialNError\\Practise\\src\\main\\java\\properties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Initialization()
	{
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\chromedriver-2.42.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Madhu\\SeleniumDependencies\\DriverExecutables\\geckodriver-23.0.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
}
