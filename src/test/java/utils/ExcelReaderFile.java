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

public class ExcelReaderFile {
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	ConfigReader config;
	String xlfilePath;
	

	public ExcelReaderFile() throws IOException {
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



	public Object[] getCode(String sheetName) throws IOException {
		sheet = wb.getSheet(sheetName);
		Object[] data = new Object[2];
		HashMap<String, String> testDataValid = new HashMap<>();
		HashMap<String, String> testDataInValid = new HashMap<>();
		testDataValid = readExcelRow("ValidCode", "testdata");
		testDataInValid = readExcelRow("InvalidCode", "testdata");
		data[0] = testDataValid.get("PythonCode");
		data[1] = testDataInValid.get("PythonCode");
		return data;
	}

}