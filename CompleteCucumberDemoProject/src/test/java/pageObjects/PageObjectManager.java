package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	// Factory Design Pattern : we will create objects of all the classes in this
	// class , so called factory design pattern

	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
}
