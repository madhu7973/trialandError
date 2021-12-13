package clickOnFilterLinks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class baseCalss {
	public static WebDriver driver;
	public static String filterOptionsClick(String filName) throws InterruptedException
	{
		String selectedFilterName= "";
		List <WebElement> filterOptions = driver.findElements(By.xpath("//div[@class='refinement Brand']/ul/li/a"));

		for(int i=0; i<filterOptions.size(); i++)
		{
			if (filterOptions.get(i).getText().equals(filName))
			{
				filterOptions.get(i).click();
				Thread.sleep(3000);
				WebElement selectedFilter = driver.findElement(By.xpath("//li[@class='selected']"));
				String selectedClassName = selectedFilter.getAttribute("class");

				if (selectedClassName.equals("selected"))

					if (driver.findElement(By.xpath("//li[@class='selected']//div")).getAttribute("class").equals("icheckbox_minimal-red checked"))
						selectedFilterName = selectedFilter.getText();
				System.out.println("check box selected of filter "+selectedFilterName );
				
				break;
			}
		}
		return selectedFilterName;
		
		//------------------------------------------------//---------------------------------------//
//		List <String> dummy = new ArrayList<String>() ;
//		for (int j=0; i<filterOptions.size(); j++)
//		{
//			String actualFilterName = filterOptions.get(j).getText().replaceAll("[^a-zA-Z]", "");
//			//String onlyFilterName = actualFilterName.replaceAll("[^a-zA-Z]", "");
//			dummy.add(actualFilterName);
//			for (String k : dummy )
//				System.out.println(k);
//		}
		
		//------------------------------------------------//---------------------------------------//
	}

}
