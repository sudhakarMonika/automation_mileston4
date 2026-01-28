package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.listeners.MyTestListener;
import herokuapp.milestorefour.pages.DigestAuthPage;

@Listeners(MyTestListener.class)
public class DigestAuthTest extends BaseTest {

    @Test(priority = 1)
    public void verifyDigestAuthPageTitle() {
        DigestAuthPage page = new DigestAuthPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyDigestAuthPageUrl() {
        DigestAuthPage page = new DigestAuthPage();
        Assert.assertTrue(
                page.getCurrentUrl().contains("digest_auth"),
                "Digest Auth URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyDigestAuthSuccessMessage() {
        DigestAuthPage page = new DigestAuthPage();
        Assert.assertTrue(
                page.getSuccessMessageText().contains("Congratulations"),
                "Digest Auth success message is incorrect");
    }

    @Test(priority = 4)
    public void verifyDigestAuthContentDisplayed() {
        DigestAuthPage page = new DigestAuthPage();
        Assert.assertTrue(
                page.isSuccessMessageDisplayed(),
                "Digest Auth success message is not displayed");
    }
}
