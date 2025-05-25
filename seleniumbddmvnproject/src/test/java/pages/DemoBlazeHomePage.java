package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.WebActions;

public class DemoBlazeHomePage {
	//Driver reference variable
	RemoteWebDriver driver;

	public DemoBlazeHomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	//Locators
	By linkWelcome=By.id("nameofuser");
	By logoutLink=By.id("logout2");
	By linkLaptops=By.xpath("//a[text()='Laptops']");
	By linkLaptop1=By.xpath("//a[text()='Sony vaio i5']");

	//Functionalities
	public String getWelcomeText() {
		String value=WebActions.getText(driver, linkWelcome);
		return value;
	}

	public void clickOnLogout() {
		//driver.findElement(logoutLink).click();
		WebActions.click(driver, logoutLink);
	}
	
	public void clickOnLaptopsLink() {
		WebActions.click(driver, linkLaptops);
	}
	public void clickOnLaptop1() {
		WebActions.click(driver, linkLaptop1);
	}

}
