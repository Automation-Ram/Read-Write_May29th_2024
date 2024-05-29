package com.qa.testng;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritetheData {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("EmpInfo");

		ArrayList<Object[]> empData = new ArrayList<Object[]>();
		empData.add(new Object[] { "Emp", "Name", "job" });
		empData.add(new Object[] { 1, "Ram", "Automation" });
		empData.add(new Object[] { 2, "Rakesh", "QA" });

		int rownum = 0;
		for (Object[] emp : empData) {
			XSSFRow row = sheet.createRow(rownum++);
			int cellNum = 0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(cellNum++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}

		}

		String filePath = "C:\\Users\\RAM79\\eclipse-workspace\\javaprograms\\DataReadWrite\\src\\main\\java\\datafiles\\emp.xlsx";
		FileOutputStream outstream = new FileOutputStream(filePath);
		workbook.write(outstream);
		outstream.close();
		System.out.println("Sucessssssssssssssssssssssss");

	}

}
