package loginScenarios;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalss extends BaseTest {

	ArrayList<String> expErrorMsgList = new ArrayList<String>();

	public static String sheetName = "Login";

	@DataProvider
	public Object[][] getTestData() throws IOException {
		Object[][] data = TestData.testData("Login");
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void LoginTest(String uname, String pword) throws InterruptedException {
		TestPage tp = new TestPage();
//		ArrayList<String> str = 
		tp.inValidLogin(uname, pword);
		System.out.println(errorMsgUtil.actualErrorMsgList);
//		int size = str.size();
//		int aSize = actualErrorMsgList.size();
//		int eSize = expErrorMsgList.size();

		if (errorMsgUtil.actualErrorMsgList.size() >= 7) {
			expErrorMsgList.add("Authentification incorrecte.");
			expErrorMsgList.add("Authentification incorrecte.");
			expErrorMsgList.add("Entrez votre adresse e-mail.");
			expErrorMsgList.add("Entrez votre adresse e-mail.");
			expErrorMsgList.add("Authentification incorrecte.");
			expErrorMsgList.add("Authentification incorrecte.");
			expErrorMsgList.add("https://www.loreal-paris.fr/");
			System.out.println("comparing");
			Assert.assertEquals(errorMsgUtil.actualErrorMsgList, expErrorMsgList);

		}
	}
}
