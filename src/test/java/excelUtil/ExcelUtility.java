package excelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
//	public static String excel_path = "D:\\APITestingProjectsWorkspace"
//			+ "\\RestAssuredCucumber\\RestAssuredCucumber\\TestData.xlsx";
//
//	public String[][] testData(String sheetName) throws EncryptedDocumentException, IOException {
//		FileInputStream file = new FileInputStream(excel_path);
//
//		Workbook book = WorkbookFactory.create(file);
//
//		Sheet sheet = book.getSheet(sheetName);
//
//		String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//		}
//		return data;
//	}
	
	String value;
	public String testData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\APITestingProjectsWorkspace\\RestAssuredCucumber\\"
				+ "RestAssuredCucumber\\TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				
				XSSFCell cell = row.getCell(j);
				value = cell.getStringCellValue();
			}
			
		}
		return value;
	}
	
}
