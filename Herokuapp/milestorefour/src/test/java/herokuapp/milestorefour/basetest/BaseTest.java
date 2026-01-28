package herokuapp.milestorefour.basetest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import herokuapp.milestorefour.utility.ConfigReader;
import herokuapp.milestorefour.utility.DriverFactory;

public class BaseTest {
	@BeforeClass
	public void beforeClass() {
	}
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser) {
		try {
			DriverFactory.initDriver(browser);
			DriverFactory.getDriver()
            .get(ConfigReader.get("base.url"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		try {
			DriverFactory.quitDriver();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
	}
}

