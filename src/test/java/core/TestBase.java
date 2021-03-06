package core;

import org.openqa.selenium.WebDriver;

public class TestBase {
	public WebDriver driver;
	
	public TestBase() {
		this.driver = DriverFactory.getDriver();
	}
	

}
