package com.milestone.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.milestone.four.utility.DriverFactory;
import com.milestone.four.utility.WaitUtil;

public class BasicAuthPage {

    private WebDriver driver;

    public BasicAuthPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openBasicAuthPage();
    }

    // Success message
    @FindBy(tagName = "p")
    private WebElement successMsg;

    // Navigate using auth in URL
    public void openBasicAuthPage() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WaitUtil.defaultWait();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getSuccessMessage() {
        return successMsg.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMsg.isDisplayed();
    }
}
