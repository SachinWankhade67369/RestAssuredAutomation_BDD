package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// To get the number of Row
	public static int getRowCount(String xlFile_Path, String xlSheet_name) {

		int rowcount = 0;
		try {

			fis = new FileInputStream(xlFile_Path);
			book = new XSSFWorkbook(fis);

			sheet = book.getSheet(xlSheet_name);

			rowcount = sheet.getLastRowNum();

			book.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("File Path is Invalid, Please provide correct path." + e.getMessage());
		}

		return rowcount;

	}

	// To get the number of Cell
	public static int getCellCount(String xlFile_Path, String xlSheet_name, int rownum) throws Exception {

		fis = new FileInputStream(xlFile_Path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(xlSheet_name);
		row = sheet.getRow(rownum);
		int colcount = row.getLastCellNum();

		book.close();
		fis.close();

		return colcount;
	}

	// To get the Cell Data
	public static String getCellData(String xlFile_Path, String xlSheet_name, int rownum, int cellnum)
			throws Exception {

		fis = new FileInputStream(xlFile_Path);

		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(xlSheet_name);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);

		String data;

		try {

			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;

		} catch (Exception e) {
			data = "";
		}

		book.close();
		fis.close();

		return data;

	}

	//To write data into Excel file
	public static void setCellData(String xlFile_Path, String xlSheet_name, int rownum, int cellnum, String data)
			throws Exception {

		fis = new FileInputStream(xlFile_Path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(xlSheet_name);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);

		cell.setCellValue(data);

		fos = new FileOutputStream(xlFile_Path);
		book.write(fos);

		book.close();
		fis.close();
		fos.close();

	}

}
