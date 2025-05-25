package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class DriverScript {
	
	KeywordActions keywordActions;
	
	public static void main(String args[]) throws IOException, NumberFormatException, InterruptedException {
		DriverScript driverScript=new DriverScript();
		driverScript.runTest("testdata/KeywordDrivenDataDummy.xlsx", "Module1", "TC2");
		
	}
	
	public DriverScript() {
		keywordActions=new KeywordActions();
	}
	
	public void runTest(String excelSheetPath,String sheetName,String inputTestCase) throws IOException, NumberFormatException, InterruptedException {
		XSSFWorkbook workbook=new XSSFWorkbook(excelSheetPath);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:="+rowCount);
		for(int i=0;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i);
			String testCaseId=getCellValue(row, 0);
			if(!testCaseId.equalsIgnoreCase(inputTestCase)) {
				continue;
			}
			String stepDescription=getCellValue(row, 1);
			String locatorType=getCellValue(row, 2);
			String locatorValue=getCellValue(row, 3);
			String testData=getCellValue(row, 4);
			String action=getCellValue(row, 5);
			
			
			//System.out.println(testCaseId+"--"+stepDescription+"--"+locatorType+"--"+locatorValue+"--"+testData+"--"+action);
			//Reporter.log(testCaseId+"--"+stepDescription+"--"+locatorType+"--"+locatorValue+"--"+testData+"--"+action, true);
			keywordActions.performAction(locatorType, locatorValue, testData, action);
		
		}
	}
	
	public  String getCellValue(XSSFRow row,int columnIndex) {
		if(row.getCell(columnIndex)==null) {
			return "";
		}
		else {
			return row.getCell(columnIndex).getStringCellValue();
		}
	}

}
