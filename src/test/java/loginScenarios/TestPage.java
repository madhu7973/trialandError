package loginScenarios;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage extends BaseTest {

	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwd;

	@FindBy(xpath = "(//input[@type='submit'])[3]")
	private WebElement loginSubmitBtn;

//	----------------------------------

//	@FindBy(xpath = "//div[@class= 'error-text']")
//	private WebElement invalidCreds;
//
//	@FindBy(xpath = "//label[@id='email-error']")
//	private WebElement invalidEmail;
//
//	@FindBy(xpath = "//label[@id='email-error']")
//	private WebElement noEmail;
//
//	@FindBy(xpath = "//label[@id='password-error']")
//	private WebElement lessPwd;
//
//	@FindBy(xpath = "/label[@id='password-error']")
//	private WebElement noPwd;

	@FindBy(xpath = "//label[@id='email-error']")
	private WebElement emailErrorMsg;

	@FindBy(xpath = "//label[@id='password-error']")
	private WebElement pwdErrorMsg;

	@FindBy(xpath = "//div[@class='error-text']")
	private WebElement generalErrorMsg;

	public TestPage() {
		PageFactory.initElements(driver, this);
	}

	public void inValidLogin(String un, String pass) throws InterruptedException {

		username.sendKeys(un);
		Thread.sleep(1000);
		pwd.sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class, 'cookies-button')]")).click();
		Thread.sleep(2000);
		loginSubmitBtn.click();
		String url = driver.getCurrentUrl();
//		String xpath = "";
		String error = "";
//		return url; // url: Landing and Profile Page:
		// https://www.loreal-paris.fr/compte/accountdetails

		if (url.equalsIgnoreCase("https://www.loreal-paris.fr/login")) {
			try {
				error = emailErrorMsg.getText();
			}

			catch (NoSuchElementException e) {
				try {
					error = generalErrorMsg.getText();
				} catch (NoSuchElementException e1) {
					// TODO: handle exception
				}
				try {
					error = pwdErrorMsg.getText();
				} catch (NoSuchElementException e2) {
					error = driver.getCurrentUrl();
				}
//				error = pwdErrorMsg.getText();
//				while (e != null) {
//					error = driver.getCurrentUrl();
//					if (url.equalsIgnoreCase("https://www.loreal-paris.fr/")) {
//						error = driver.getCurrentUrl();
//					}

//				}
			}
		}

//		else if (url.equalsIgnoreCase("https://www.loreal-paris.fr/login")) {
//			try {
//				error = generalErrorMsg.getText();
//
//			} catch (NoSuchElementException e) {
//
//			}
//
//		}

//		else if (url.equalsIgnoreCase("https://www.loreal-paris.fr/")) {
//
//			error = driver.getCurrentUrl();
//		}

		errorMsgUtil.actualErrorMsgList.add(error);
//		return actualErrorMsgList;

//		System.out.println(actualErrorMsgList);
	}

}
