package com.sostv.app.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SostvDataImport {
	
	public static void main(String[] args) {
		try {
			saveExcelData("F:/SOSTV网站数据/真理课堂.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveExcelData(String path) throws Exception{
		InputStream is = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			System.out.println(ExcelUtils.getStringCellValue(row.getCell(0)));
		}
	}
}
