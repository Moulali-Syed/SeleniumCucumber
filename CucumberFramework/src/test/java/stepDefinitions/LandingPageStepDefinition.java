package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
//	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);

		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Product name is " + landingPageProductName);
	}

}
