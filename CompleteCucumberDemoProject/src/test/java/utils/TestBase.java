package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("QAUrl");
		
		if (driver == null) {
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(properties.getProperty("browser")=="edge") {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			driver.get(url);
		}
		return driver;
	}
}
