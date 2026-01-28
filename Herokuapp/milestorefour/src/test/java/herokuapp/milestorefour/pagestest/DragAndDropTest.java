package herokuapp.milestorefour.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import herokuapp.milestorefour.basetest.BaseTest;
import herokuapp.milestorefour.listeners.MyTestListener;
import herokuapp.milestorefour.pages.DragAndDropPage;

@Listeners(MyTestListener.class)
public class DragAndDropTest extends BaseTest {

    @Test(priority = 1)
    public void verifyDragAndDropPageTitle() {
        DragAndDropPage page = new DragAndDropPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyDragAndDropPageUrl() {
        DragAndDropPage page = new DragAndDropPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/drag_and_drop",
                "Drag and Drop URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyDragAndDropFunctionality() {
        DragAndDropPage page = new DragAndDropPage();

        page.dragAToB();

        Assert.assertEquals(
                page.getColumnAText(),
                "B",
                "Drag and Drop did not work as expected");
    }
}
