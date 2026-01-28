package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.listeners.MyTestListener;
import herokuapp.milestorefour.pages.CheckboxesPage;

@Listeners(MyTestListener.class)
public class CheckboxesTest extends BaseTest {

    @Test(priority = 1)
    public void verifyCheckboxesPageTitle() {
        CheckboxesPage page = new CheckboxesPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyCheckboxesPageUrl() {
        CheckboxesPage page = new CheckboxesPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/checkboxes",
                "Checkboxes page URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyCheckboxCount() {
        CheckboxesPage page = new CheckboxesPage();
        Assert.assertEquals(
                page.getCheckboxCount(),
                2,
                "Checkbox count is incorrect");
    }

    @Test(priority = 4)
    public void verifyCheckboxSelection() {
        CheckboxesPage page = new CheckboxesPage();

        // First checkbox select
        page.selectCheckbox(0);
        Assert.assertTrue(
                page.isCheckboxSelected(0),
                "First checkbox is not selected");

        // Second checkbox unselect
        page.unselectCheckbox(1);
        Assert.assertFalse(
                page.isCheckboxSelected(1),
                "Second checkbox is still selected");
    }
}
