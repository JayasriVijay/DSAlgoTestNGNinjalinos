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

	public int getColNumber(String cellName) {
		return colNums.get(cellName);
	}

	public String getData(String sheetName, int rowNum, String cellName) throws IOException {
		sheet = wb.getSheet(sheetName);
		populateColumNums();
		String cellData = "";
		int cellNum = getColNumber(cellName);
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

}
