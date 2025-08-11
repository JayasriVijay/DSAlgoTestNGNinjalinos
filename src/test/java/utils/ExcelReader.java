package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileInputStream fis;
	// public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	ConfigReader config;
	String xlfilePath;
	HashMap<String, Integer> colNums = null;

	public ExcelReader() throws IOException {
		this.config = new ConfigReader();
		this.xlfilePath = config.get_prop_value("path");
		this.fis = new FileInputStream(xlfilePath);
		this.wb = new XSSFWorkbook(fis);

	}

	public void populateColumNums() {
		colNums = new HashMap<String, Integer>();
		int colIndex = 0;
		row = sheet.getRow(0);
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			String cellName = cell.getStringCellValue();
			colNums.put(cellName, colIndex);
			colIndex++;
		}
	}

//	public int getColNumber(String cellName) {
//		return colNums.get(cellName);
//	}

	public String getData(String sheetName, int rowNum, String cellName) throws IOException {
		sheet = wb.getSheet(sheetName);
		populateColumNums();
		String cellData = "";
		//int cellNum = getColNumber(cellName);
		int cellNum = colNums.get(cellName);
		cellData = getData_UsingColNum(sheetName, rowNum, cellNum);
		return cellData;

	}

	public String getData_UsingColNum(String sheetName, int rowNum, int cellNum) throws IOException {

		sheet = wb.getSheet(sheetName);

		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String cellData;
		try {
			DataFormatter df = new DataFormatter();
			cellData = df.formatCellValue(cell);
		} catch (Exception e) {
			cellData = "";
		}
		return cellData;

	}
	
	public Object[] getCode(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[sheet.getLastRowNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			data[i]= sheet.getRow(i+1).getCell(0).toString();
		}
		
        return data;
	}
	
	public Object[] getCode_arrayPractice(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[sheet.getRow(1).getLastCellNum()];
		for(int j=0; j<sheet.getRow(1).getLastCellNum(); j++) {
			data[j]= sheet.getRow(1).getCell(j).toString();
		}
		
        return data;
	}
	
	public Object[][] getLoginTestData(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][2];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0 ; j<2;j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		
        return data;
	}
	
	public Object[][] getRegisterTestData(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][3];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0;j<3;j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		
        return data;
	}

}
