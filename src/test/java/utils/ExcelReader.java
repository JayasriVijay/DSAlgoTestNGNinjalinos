package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileInputStream fis;
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

	public HashMap<String, String> readExcelRow(String sheetName, String ScenarioName) {
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

	public String inputTestData(String sheetName, String ScenarioName, String key) {
		HashMap<String, String> testData = new HashMap<>();
		testData = readExcelRow(sheetName, ScenarioName);
		return testData.get(key);

	}

	public Object[] getCode(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[2];
		data[0] = inputTestData("testdata", "PracticeQ3validcode", "PythonCode");
		data[1] = inputTestData("testdata", "PracticeQ4validcode", "PythonCode");
		return data;
	}

}
