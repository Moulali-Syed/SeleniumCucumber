package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {

	public String offerPageProductName;

	public TestContextSetup testContextSetup;

	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);;
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();
	}

	public void switchToOffersPage() {
		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.selectTopDeals();
		Set<String> s1 = testContextSetup.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_mathces_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}
