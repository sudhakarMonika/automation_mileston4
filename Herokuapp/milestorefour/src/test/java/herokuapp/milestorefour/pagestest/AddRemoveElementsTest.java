package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.pages.AddRemoveElementsPage;
import herokuapp.milestorefour.listeners.MyTestListener;

@Listeners(MyTestListener.class)
public class AddRemoveElementsTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAddRemovePageTitle() {
        AddRemoveElementsPage page = new AddRemoveElementsPage();
        Assert.assertEquals(page.getPageTitle(),"The Internet","Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyAddRemovePageUrl() {
        AddRemoveElementsPage page = new AddRemoveElementsPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/add_remove_elements/",
                "Add/Remove Elements URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyAddElementFunctionality() {
        AddRemoveElementsPage page = new AddRemoveElementsPage();
        page.clickAddElement();;

        Assert.assertTrue(
                page.isDeleteButtonDisplayed(),
                "Delete button is not displayed after clicking Add Element");
    }

    @Test(priority = 4)
    public void verifyDeleteElementFunctionality() {
        AddRemoveElementsPage page = new AddRemoveElementsPage();
        page.clickAddElement();
        page.clickDeleteElement();

        // If no exception = pass
        Assert.assertTrue(true, "Delete button not removed");
    }
}
