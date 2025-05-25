package utilities;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtils {
	
	
	
	public static RemoteWebDriver getDriver() {
		Logger logger=LoggerUtility.getLogger("BrowserUtils.getDriver()");
		//A new comment - 25th May-2025
		System.out.println("Testing");
		RemoteWebDriver driver=null;
		String browserName=System.getProperty("browser");
		System.out.println("Browser passed from command line argument is:="+browserName);
		logger.debug("Browser passed from command line argument is:="+browserName);
		if(browserName==null || browserName.isEmpty()) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			logger.info("Browser passed is empty or null. Hence default browser Chrome is selected");
			driver=new  ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

}
