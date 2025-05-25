package steps;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.BrowserUtils;

public class StepDefination {
	RemoteWebDriver driver;
	DemoBlazeIndexPage indexPage;
	
	@Given("User opens the Browser")
	public void user_opens_the_browser() {
	   driver=BrowserUtils.getDriver();
	}

	@When("User navigate to the DemoBlaze application URL")
	public void user_navigate_to_the_demo_blaze_application_url() {
	    driver.get("https://www.demoblaze.com/index.html");
	}

	@And("User clicks on Login link")
	public void user_clicks_on_login_link() {
	    indexPage=new DemoBlazeIndexPage(driver);
	    indexPage.clickOnLoginLink();
	}

	@And("Enter user name as {string} and password as {string}")
	public void enter_user_name_as_and_password_as(String userName, String password) {
		indexPage=new DemoBlazeIndexPage(driver);
		indexPage.enterUserName(userName);
		indexPage.enterPassword(password);
	}

	@And("clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException {
		indexPage=new DemoBlazeIndexPage(driver);
		indexPage.clickOnLoginButton();
		Thread.sleep(5000);
	}

	@Then("the home page should be displayed with welcome message")
	public void the_home_page_should_be_displayed_with_welcome_message() {
	    DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
	    String text=homePage.getWelcomeText();
	    System.out.println(text);
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {
	   driver.quit();
	}

	@Then("Alert message with error should be shown to the user")
	public void alert_message_with_error_should_be_shown_to_the_user() {
	    DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
	    String message=indexPage.getLoginErrorMessage();
	    Assert.assertEquals(message, "User does not exis");
	    System.out.println(message);
	}
	
	@And("user clicks on Laptops link")
	public void clickOnLaptopLink() {
		 DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		 homePage.clickOnLaptopsLink();
	}
	
	@And("user clicks on Laptop1 link")
	public void clickOnLaptop1Link() {
		 DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		 homePage.clickOnLaptop1();
	}
}
