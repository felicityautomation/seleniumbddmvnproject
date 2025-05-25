package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.LoggerUtility;
import utilities.WebActions;

public class DemoBlazeIndexPage {
	//Driver reference variable
	RemoteWebDriver driver;
	
	public DemoBlazeIndexPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	//1. Locators
	By linkLogin=By.id("login2");
	By inputUserName=By.id("loginusername");
	By inputPassword=By.id("loginpassword");
	By buttonLogin=By.xpath("//button[text()='Log in']");
	
	//2. Functionalities
	public void clickOnLoginLink() {
		//driver.findElement(linkLogin).click();
		WebActions.click(driver, linkLogin);
	}
	
	public void enterUserName(String userName) {
		//driver.findElement(inputUserName).sendKeys(inputUserName);
		WebActions.setText(driver, inputUserName, userName);
	}
	
	public void enterPassword(String password) {
		//driver.findElement(inputPassword).sendKeys(password);
		WebActions.setText(driver, inputPassword, password);
	}
	
	public void clickOnLoginButton() {
		//driver.findElement(buttonLogin).click();
		WebActions.click(driver, buttonLogin);
	}
	
	public void login(String userName,String password) {
		Logger logger=LoggerUtility.getLogger("DemoBlazeIndexPage.login()");
		logger.debug("Start of the Login Method of Demo Blaze");
		this.clickOnLoginLink();
		this.enterUserName(userName);
		this.enterPassword(password);
		this.clickOnLoginButton();
		logger.debug("End of the Login Method of Demo Blaze");
	}
	
	public String getLoginErrorMessage() {
		String message=WebActions.getAlertMessage(driver);
		return message;
	}
	
}
