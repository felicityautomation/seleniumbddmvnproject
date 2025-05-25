package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebActions {
	
	
	public static void openUrl(RemoteWebDriver driver, String url) {
		Reporter.log("Opening the URL:="+url, true);
		driver.get(url);
	}
	
	public static String getBrowserTitle(RemoteWebDriver driver) {
		Reporter.log("Getting the browser title",true);
		String title=driver.getTitle();
		Reporter.log("Title of the browser is:="+title);
		return title;
	}
	
	public static void quitBrowser(RemoteWebDriver driver) {
		Reporter.log("Quitting the browser",true);
		driver.quit();
	}
	
	public static void setText(RemoteWebDriver driver, By locator, String text) {
		Reporter.log("Setting the text:="+text+" in the locator:="+locator.toString(),true);
		driver.findElement(locator).sendKeys(text);
	}

	public static void click(RemoteWebDriver driver, By locator) {
		Reporter.log("Clicking on the locator:="+locator.toString(),true);
		driver.findElement(locator).click();
	}
	
	public static void navigateTo(RemoteWebDriver driver,String url) {
		Reporter.log("Navigating to the URL:="+url,true);
		driver.navigate().to(url);
	}
	
	public static String getAlertMessage(RemoteWebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Reporter.log("Getting the text from Alert popup",true);
		String message=driver.switchTo().alert().getText();
		Reporter.log("Alert message is:="+message,true);
		Reporter.log("Accepting the alert",true);
		driver.switchTo().alert().accept();
		return message;
	}
	
	public static String getText(RemoteWebDriver driver, By locator) {
		
		String text=driver.findElement(locator).getText();
		Reporter.log("Text of the element is:="+text,true);
		return text;
	}
	
	public static void takeScreenshot(RemoteWebDriver driver, String nameOfScreenshot) {
		File myScreenshot=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("screenshot/"+nameOfScreenshot+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
