package properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getProperties extends selectBrowser{
	
	selectBrowser browser = new selectBrowser();
	
	@BeforeMethod
	public void setEnvi()
	{
		browser.sample();
		browser.Initialization();
	}
	
	@Test
	public void dummyMethod() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}
	

}
