package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true,
tags = "@PlaceOrder or @OffersPage" , plugin= {"html:target/cucumber.html","json:target/cucumber.json"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	// we are overriding the scenarios method of AbstractTestNGCucumberTests class
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
