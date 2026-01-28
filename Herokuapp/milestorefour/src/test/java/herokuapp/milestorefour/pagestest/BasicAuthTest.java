package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.pages.BasicAuthPage;
import herokuapp.milestorefour.listeners.MyTestListener;

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
