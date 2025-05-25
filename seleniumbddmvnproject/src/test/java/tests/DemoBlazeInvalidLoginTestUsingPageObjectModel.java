package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.BrowserUtils;

public class DemoBlazeInvalidLoginTestUsingPageObjectModel {
	
	@Test
	public void demoBlazeLoginTest() throws InterruptedException {
		RemoteWebDriver driver=BrowserUtils.getDriver();
		driver.get("https://www.demoblaze.com/index.html");
		
		DemoBlazeIndexPage demoBlazeIndexPage=new DemoBlazeIndexPage(driver);
		demoBlazeIndexPage.login("bharathedu1", "123456904");
		Thread.sleep(5000);
		String message=demoBlazeIndexPage.getLoginErrorMessage();
		Assert.assertEquals(message, "Wrong password.");
		
		driver.quit();
	}

}
