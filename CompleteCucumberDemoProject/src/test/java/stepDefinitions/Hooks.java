package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	// runs after each Scenario
	@After
	public void AfterScenario() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	
	//we pass parameter Scenario , it has every information about the Scneario that is running
	//it knows scenario name
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws WebDriverException, IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		//executes only if any step is failed
		if(scenario.isFailed()) {
			//screenshot
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");//1st argument - convert file format to byte format
			//so use commons-io dependency 
		}
	}
}
