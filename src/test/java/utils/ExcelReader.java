package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
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
	HashMap<String, Integer> rowNums = null;

	public ExcelReader() throws IOException {
		this.config = new ConfigReader();
		this.xlfilePath = config.get_prop_value("path");
		this.fis = new FileInputStream(xlfilePath);
		this.wb = new XSSFWorkbook(fis);

	}

	public HashMap<String, String> readExcelRow(String ScenarioName, String sheetName) {
		HashMap<String, String> testData = new HashMap<>();
		DataFormatter formatter = new DataFormatter();

		sheet = wb.getSheet(sheetName);
		Row header = sheet.getRow(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String scenario = formatter.formatCellValue(row.getCell(0)).trim();

			if (scenario.equalsIgnoreCase(ScenarioName.trim())) {
				for (int j = 1; j < row.getLastCellNum(); j++) {
					String key = formatter.formatCellValue(header.getCell(j)).trim();
					String value = formatter.formatCellValue(row.getCell(j)).trim();
					testData.put(key, value);
				}
				break;
			}
		}

		return testData;
	}
	
	public String inputTestData(String ScenarioName, String sheetName, String key) {
		HashMap<String, String> testData = new HashMap<>();
		testData = readExcelRow(ScenarioName,sheetName); 
		return testData.get(key);
		
	}

//	public void populateColumNums() {
//		colNums = new HashMap<String, Integer>();
//		int colIndex = 1;
//		row = sheet.getRow(0);
//		Iterator<Cell> cells = row.cellIterator();
//		while (cells.hasNext()) {
//			Cell cell = cells.next();
//			String cellName = cell.getStringCellValue();
//			colNums.put(cellName, colIndex);
//			colIndex++;
//		}
//	}

//	public void populateRowNums() {
//		rowNums = new HashMap<String, Integer>();
//		int rowIndex = 1;
//		int i = 1;
//		while (i <= sheet.getLastRowNum()) {
//
//			Row row = sheet.getRow(i);
//			if (row != null) {
//				Cell cell = row.getCell(0);
//				if (cell != null) {
//					DataFormatter formatter = new DataFormatter();
//					String rowName = formatter.formatCellValue(cell);
//					rowNums.put(rowName, rowIndex);
//				}
//			}
//
//			i++;
//			rowIndex++;
//		}
//
//	}

//	public int getColNumber(String cellName) {
//		return colNums.get(cellName);
//	}

//	public String getData(String sheetName, String rowName, String cellName) throws IOException {
//		sheet = wb.getSheet(sheetName);
//		populateColumNums();
//		populateRowNums();
//		String cellData = "";
//		// int cellNum = getColNumber(cellName);
//		int cellNum = colNums.get(cellName);
//		int rowNum = rowNums.get(rowName);
//		cellData = getData_UsingColNum(sheetName, rowNum, cellNum);
//		return cellData;
//
//	}

//	public String getData_UsingColNum(String sheetName, int rowNum, int cellNum) throws IOException {
//
//		sheet = wb.getSheet(sheetName);
//
//		row = sheet.getRow(rowNum);
//		cell = row.getCell(cellNum);
//		String cellData;
//		try {
//			DataFormatter df = new DataFormatter();
//			cellData = df.formatCellValue(cell);
//		} catch (Exception e) {
//			cellData = "";
//		}
//		return cellData;
//
//	}

	public Object[] getCode(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[sheet.getLastRowNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			data[i] = sheet.getRow(i + 1).getCell(1).toString();
		}

		return data;
	}

	public Object[] getCode_arrayPractice(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[sheet.getRow(1).getLastCellNum()];
		for (int j = 1; j < sheet.getRow(1).getLastCellNum(); j++) {
			data[j] = sheet.getRow(1).getCell(j).toString();
		}

		return data;
	}

	public Object[][] getLoginTestData(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][2];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 1; j <= 2; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}

		}

		return data;
	}

	public Object[][] getRegisterTestData(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][3];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 1; j <= 3; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}

		}

		return data;
	}

}
