package excelUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

public class DataDriven {
	static ExcelUtility eu = new ExcelUtility();
	static List<String> list = new ArrayList<String>();
	static String str;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		String[][] dataArray = eu.testData("Sheet1");
//		for (String[] array : dataArray) {
//			list.addAll(Arrays.asList(array));
//		}
//		System.out.println(list);
//		System.out.println(list.get(0));
		
//		System.out.println(dataArray.length);
//		
//		for (int i = 0; i < dataArray.length; i++) {
//			for (int j = 0; j < dataArray[i].length; j++) {
//				System.out.println(dataArray[i][j] + " "); 
//			}
//			
//		}
		
		String str = eu.testData();
		
		System.out.println(str);
	}

}
