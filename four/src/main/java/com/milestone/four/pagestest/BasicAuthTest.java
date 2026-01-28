package com.milestone.four.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.milestone.four.basetest.BaseTest;
import com.milestone.four.pages.BasicAuthPage;
import com.milestone.four.listeners.MyTestListener;

@Listeners(MyTestListener.class)
public class BasicAuthTest extends BaseTest {

    @Test(priority = 1)
    public void verifyBasicAuthPageTitle() {
        BasicAuthPage page = new BasicAuthPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyBasicAuthUrl() {
        BasicAuthPage page = new BasicAuthPage();
        Assert.assertTrue(
                page.getCurrentUrl().contains("basic_auth"),
                "Basic Auth URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyBasicAuthSuccessMessage() {
        BasicAuthPage page = new BasicAuthPage();
        Assert.assertTrue(
                page.getSuccessMessage().contains("Congratulations"),
                "Basic Auth success message is incorrect");
    }

    @Test(priority = 4)
    public void verifyBasicAuthContentDisplayed() {
        BasicAuthPage page = new BasicAuthPage();
        Assert.assertTrue(
                page.isSuccessMessageDisplayed(),
                "Success message is not displayed");
    }
}
