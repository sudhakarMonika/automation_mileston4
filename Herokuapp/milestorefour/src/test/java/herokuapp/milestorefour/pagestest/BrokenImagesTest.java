package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.listeners.MyTestListener;
import herokuapp.milestorefour.pages.BrokenImagesPage;

@Listeners(MyTestListener.class)
public class BrokenImagesTest extends BaseTest {

    @Test(priority = 1)
    public void verifyBrokenImagesPageTitle() {
        BrokenImagesPage page = new BrokenImagesPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyBrokenImagesPageUrl() {
        BrokenImagesPage page = new BrokenImagesPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/broken_images",
                "Broken Images URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyImagesPresentOnPage() {
        BrokenImagesPage page = new BrokenImagesPage();
        Assert.assertTrue(
                page.getTotalImagesCount() > 0,
                "No images found on Broken Images page");
    }

    @Test(priority = 4)
    public void verifyBrokenImagesCount() {
        BrokenImagesPage page = new BrokenImagesPage();
        int brokenCount = page.getBrokenImagesCount();

        Assert.assertTrue(
                brokenCount > 0,
                "No broken images found, but expected broken images");
    }
}
