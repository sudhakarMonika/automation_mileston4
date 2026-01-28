package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.pages.ABTestingPage;
import herokuapp.milestorefour.listeners.*;

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
