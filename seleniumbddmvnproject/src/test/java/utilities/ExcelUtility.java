package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static void main(String args[]) throws IOException {
		Object[][] myData=ExcelUtility.readFromExcel("testdata/mytestdata.xlsx", "Registration");
		for(int i=0;i<myData.length;i++) {
			for(int j=0;j<myData[i].length;j++) {
				System.out.println(myData[i][j]);
			}
		}
		
		
//		List<String> excelData = readExcelData("testdata/mytestdata.xlsx", "Registration");
//        // Example usage in Selenium test
//        for (String item : excelData) {
//            System.out.println("Cell data: " + item);
//        }
		
	}

	
	public static Object[][] readFromExcel(String excelSheetPath,String sheetName) throws IOException {
		//Access the workbook
				XSSFWorkbook workbook=new XSSFWorkbook(excelSheetPath);
				XSSFSheet sheet=workbook.getSheet(sheetName);
				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("Row count:="+rowCount);
				
				XSSFRow row=sheet.getRow(0);
				int colCount=row.getPhysicalNumberOfCells();
				System.out.println("Columns count:="+colCount);
				
				Object[][] data=new Object[rowCount-1][colCount];
				
				//XSSFCell cell=row.getCell(1);
				//String cellValue=cell.getStringCellValue();
				//System.out.println(cellValue);
				
				for(int i=1;i<rowCount;i++) {
					for(int j=0;j<colCount;j++) {
						String value=sheet.getRow(i).getCell(j).getStringCellValue();
						//System.out.println(value);
						data[i-1][j]=value;
					}
				}
				
				workbook.close();
				return data;
	}
	
	    public static List<String> readExcelData(String filePath, String sheetName) {
	        List<String> data = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    data.add(cell.toString());
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
//	    public static void main(String[] args) {
//	        String filePath = "testdata.xlsx";
//	        String sheetName = "Sheet1";
//	        List<String> excelData = readExcelData(filePath, sheetName);
//	        // Example usage in Selenium test
//	        for (String item : excelData) {
//	            System.out.println("Cell data: " + item);
//	        }
//	    }
}

