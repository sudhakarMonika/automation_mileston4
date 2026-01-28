package com.milestone.four.basetest;

import org.testng.annotations.*;
import com.milestone.four.utility.ConfigReader;
import com.milestone.four.utility.DriverFactory;

public class BaseTest {

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(@Optional("chrome") String browser) {
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver()
				.get(ConfigReader.get("base.url"));
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		DriverFactory.quitDriver();
	}
}
