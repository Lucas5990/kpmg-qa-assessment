package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// driver.manage().window().setSize(new Dimension (1200, 765));
		driver.manage().window().maximize();
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
