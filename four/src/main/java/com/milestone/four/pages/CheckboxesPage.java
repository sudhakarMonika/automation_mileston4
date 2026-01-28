package com.milestone.four.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.milestone.four.utility.DriverFactory;
import com.milestone.four.utility.WaitUtil;

public class CheckboxesPage {

    private WebDriver driver;

    public CheckboxesPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openCheckboxesPage();
    }

    // All checkboxes
    @FindBy(css = "#checkboxes input[type='checkbox']")
    private List<WebElement> checkboxes;

    // Navigate
    public void openCheckboxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Checkbox actions
    public void selectCheckbox(int index) {
        if (!checkboxes.get(index).isSelected()) {
            checkboxes.get(index).click();
            WaitUtil.defaultWait();
        }
    }

    public void unselectCheckbox(int index) {
        if (checkboxes.get(index).isSelected()) {
            checkboxes.get(index).click();
            WaitUtil.defaultWait();
        }
    }

    // Validations
    public boolean isCheckboxSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    public int getCheckboxCount() {
        return checkboxes.size();
    }
}
