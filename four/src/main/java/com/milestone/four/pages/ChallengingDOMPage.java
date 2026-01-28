package com.milestone.four.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.milestone.four.utility.DriverFactory;
import com.milestone.four.utility.WaitUtil;

public class ChallengingDOMPage {

    private WebDriver driver;

    public ChallengingDOMPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openChallengingDOMPage();
    }

    // Buttons (dynamic IDs → stable selectors)
    @FindBy(css = "a.button")
    private WebElement blueButton;

    @FindBy(css = "a.button.alert")
    private WebElement redButton;

    @FindBy(css = "a.button.success")
    private WebElement greenButton;

    // Table rows
    @FindBy(css = "table tbody tr")
    private List<WebElement> tableRows;

    // Navigate
    public void openChallengingDOMPage() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Button actions
    public void clickBlueButton() {
        blueButton.click();
        WaitUtil.defaultWait();
    }

    public void clickRedButton() {
        redButton.click();
        WaitUtil.defaultWait();
    }

    public void clickGreenButton() {
        greenButton.click();
        WaitUtil.defaultWait();
    }

    // Table validations
    public int getTableRowCount() {
        return tableRows.size();
    }

    public String getCellValue(int row, int column) {
        return driver.findElement(
                By.xpath("//table/tbody/tr[" + row + "]/td[" + column + "]"))
                .getText();
    }
}
