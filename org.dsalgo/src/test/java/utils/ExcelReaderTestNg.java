package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderTestNg {
	
		private static final String STRING = null;
		public static String filePath = "src/test/resources/testData (1).xlsx";
		


		public static Map<String, String> readExcelRow(String ScenarioName, String sheetName) {
		    Map<String, String> testData = new HashMap<>();
		    DataFormatter formatter = new DataFormatter();

		    try (FileInputStream fis = new FileInputStream(filePath);
		         Workbook workbook = new XSSFWorkbook(fis)) {

		        Sheet sheet = workbook.getSheet(sheetName);
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

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return testData;
		}
	    
	}
