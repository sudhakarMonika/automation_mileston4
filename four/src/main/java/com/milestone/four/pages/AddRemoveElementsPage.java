package com.milestone.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.milestone.four.utility.DriverFactory;
import com.milestone.four.utility.WaitUtil;

public class AddRemoveElementsPage {

    private WebDriver driver;

    public AddRemoveElementsPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openAddRemovePage();
    }

    // Link on home page
    @FindBy(xpath = "//a[text()='Add/Remove Elements']")
    private WebElement addRemoveLink;

    // Add Element button
    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementBtn;

    // Delete button
    @FindBy(className = "added-manually")
    private WebElement deleteBtn;

    // Navigate to page
    public void openAddRemovePage() {
        addRemoveLink.click();
        WaitUtil.defaultWait();
    }

    // Actions
    public void clickAddElement() {
        addElementBtn.click();
        WaitUtil.defaultWait();
    }

    public void clickDeleteElement() {
        deleteBtn.click();
        WaitUtil.defaultWait();
    }

    // Validations
    public boolean isDeleteButtonDisplayed() {
        return deleteBtn.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
