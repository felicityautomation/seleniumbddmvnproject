package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class KeywordActions {
	
	RemoteWebDriver driver;
	
	public By getLocator(String locatorType,String locatorValue) {
		By locator=null;
		if(locatorType.equalsIgnoreCase("id")) {
			locator= By.id(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("name")) {
			locator= By.name(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("xpath")) {
			locator= By.xpath(locatorValue);
		}
		return locator;
	}
	
	
	public void performAction(String locatorType,String locatorValue,String testData,String action) throws NumberFormatException, InterruptedException {
		
		switch(action) {
		case "openBrowser":
			driver=BrowserUtils.getDriver();
			break;
			
		case "openUrl":
			//Reporter.log("Opening the URL:="+testData, true);
			//driver.get(testData);
			WebActions.openUrl(driver, testData);
			break;
			
		case "verifyTitle":
			//String actualTitle=driver.getTitle();
			String actualTitle=WebActions.getBrowserTitle(driver);
			Assert.assertEquals(actualTitle, testData);
			break;
			
		case "closeBrowser":
			//driver.quit();
			WebActions.quitBrowser(driver);
			break;
			
		case "setText":
			//driver.findElement(getLocator(locatorType, locatorValue)).sendKeys(testData);
			WebActions.setText(driver, getLocator(locatorType, locatorValue), testData);
			break;
			
		case "click":
			//driver.findElement(getLocator(locatorType, locatorValue)).click();
			WebActions.click(driver, getLocator(locatorType, locatorValue));
			break;
			
		case "wait":
			Thread.sleep(Long.parseLong(testData));
			break;
			
		case "navigateToPage":
			//driver.navigate().to(testData);
			WebActions.navigateTo(driver, testData);
			break;
		}
		
	}
}
