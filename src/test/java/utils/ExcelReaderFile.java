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
	HashMap<String, Integer> colNums = null;
	HashMap<String, Integer> rowNums = null;

	public ExcelReaderFile() throws IOException {
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
		data[0] = inputTestData("testdata", "ValidCode", "PythonCode");
		data[1] = inputTestData("testdata", "InvalidCode","PythonCode");
		return data;
	}

}




//package utils;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReaderFile {
//
//    private String xlfilePath;
//
//    public ExcelReaderFile() throws IOException {
//        ConfigReader config = new ConfigReader();
//        this.xlfilePath = config.get_prop_value("path");
//    }
//
//    // Method to get cell value using Row Name and Column Name
//    public String getCellData(String sheetName, String rowName, String colName) throws IOException {
//        FileInputStream fis = new FileInputStream(xlfilePath);
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sheet = wb.getSheet(sheetName);
//        DataFormatter df = new DataFormatter();
//
//        int rowIndex = -1; 
//        int colIndex = -1;
//
//        //FINDING COL INDEX FROM HEADER ROW (ROW 0) USING COL NAME
//        //THIS LOOP TRAVERSES ACROSS DIFFERENT CELLS OF ROW EXTRACTED LIKE THE INSIDE LOOP OF VIDEO
//        XSSFRow headerRow = sheet.getRow(0);
//        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//            String headerValue = df.formatCellValue(headerRow.getCell(i)); //THIS HEADERVALUE WILL STORE CONTENT OF EACH CELL ITERATED
//            if (headerValue.equalsIgnoreCase(colName)) {
//                colIndex = i;
//                break;
//            }
//        }
//
//        if (colIndex == -1) {
//            System.out.println(colName + "not found in sheet");
//            wb.close();
//            fis.close();
//            return "";
//        }
//
//        
//        //FINDING ROW INDEX FROM FIRST COLUMN
//        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//            String firstColValue = df.formatCellValue(sheet.getRow(i).getCell(0));
//            if (firstColValue.equalsIgnoreCase(rowName)) {
//                rowIndex = i;
//                break;
//            }
//        }
//
//        if (rowIndex == -1) {
//            System.out.println(rowName + " not found in sheet ");
//            wb.close();
//            fis.close();
//            return "";
//        }
//
//        // 3. Read the cell value
//        XSSFCell cell = sheet.getRow(rowIndex).getCell(colIndex);
//        String cellValue = df.formatCellValue(cell);
//
//        wb.close();
//        fis.close();
//        return cellValue;
//    }
//}


//ROWS ARE COUNTING FROM 0 AND CELSS ARE COUNTING FROM ONE LIKE IN EXAMPLE HE HAD 6 ROWS INCLUDING HEADER BUT WHEN WE DID 
// DID SHEET.GetLastRowNum we got only 5 rows as output so for the loop having row number it will start from 0 but will
//go till <= sheet.getLastRowNum but for column/cell it gives the answer as the counting starts from 1 so we 
// need not include = in its for loop(if it begins with 0) or it should start from 1.



