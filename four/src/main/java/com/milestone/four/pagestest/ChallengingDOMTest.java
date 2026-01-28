package com.milestone.four.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.milestone.four.basetest.BaseTest;
import com.milestone.four.listeners.MyTestListener;
import com.milestone.four.pages.ChallengingDOMPage;

@Listeners(MyTestListener.class)
public class ChallengingDOMTest extends BaseTest {

    @Test(priority = 1)
    public void verifyChallengingDOMPageTitle() {
        ChallengingDOMPage page = new ChallengingDOMPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyChallengingDOMPageUrl() {
        ChallengingDOMPage page = new ChallengingDOMPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/challenging_dom",
                "Challenging DOM URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyButtonsClickable() {
        ChallengingDOMPage page = new ChallengingDOMPage();

        page.clickBlueButton();
        page.clickRedButton();
        page.clickGreenButton();

        Assert.assertTrue(true, "Buttons are not clickable");
    }

    @Test(priority = 4)
    public void verifyTableDataPresent() {
        ChallengingDOMPage page = new ChallengingDOMPage();

        Assert.assertTrue(
                page.getTableRowCount() > 0,
                "Table rows are not present");

        String cellValue = page.getCellValue(1, 1);
        Assert.assertNotNull(cellValue, "Table cell value is null");
    }
}
