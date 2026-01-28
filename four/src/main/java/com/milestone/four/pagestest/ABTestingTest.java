package com.milestone.four.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.milestone.four.basetest.BaseTest;
import com.milestone.four.pages.ABTestingPage;
import com.milestone.four.listeners.*;

@Listeners(MyTestListener.class)
public class ABTestingTest extends BaseTest {

    @Test(priority=1)
    public void verifyABTestPageTitle() {
        ABTestingPage page = new ABTestingPage();
        Assert.assertEquals(page.getPageTitle(), "The Internet", "The page title is incorrect.");
    }

    @Test(priority=2)
    public void verifyABTestHeader() {
        ABTestingPage page = new ABTestingPage();
        Assert.assertEquals(page.getHeaderText(), "A/B Test Control", "A/B Test Variation 1");
    }

    @Test(priority=3)
    public void verifyABTestLink() {
        ABTestingPage page = new ABTestingPage();
        Assert.assertEquals(page.getCurrentUrl(),"https://the-internet.herokuapp.com/abtest","Link URL is incorrect.");
    }

    @Test(priority=4)
    public void verifyABTestContent() {
        ABTestingPage page = new ABTestingPage();
        Assert.assertTrue(page.isContentDisplayed(), "Content section is not displayed.");
    }
}
