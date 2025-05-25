package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"features/Login.feature"},
		glue = {"steps"},
		plugin = {"html:target/cucumber/cucumber-test-report.html"}
		)
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
