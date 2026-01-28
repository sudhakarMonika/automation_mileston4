package com.milestone.four.pagestest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.milestone.four.basetest.BaseTest;
import com.milestone.four.listeners.MyTestListener;
import com.milestone.four.pages.ContextMenuPage;

@Listeners(MyTestListener.class)
public class ContextMenuTest extends BaseTest {

    @Test(priority = 1)
    public void verifyContextMenuPageTitle() {
        ContextMenuPage page = new ContextMenuPage();
        Assert.assertEquals(
                page.getPageTitle(),
                "The Internet",
                "Page title is incorrect");
    }

    @Test(priority = 2)
    public void verifyContextMenuPageUrl() {
        ContextMenuPage page = new ContextMenuPage();
        Assert.assertEquals(
                page.getCurrentUrl(),
                "https://the-internet.herokuapp.com/context_menu",
                "Context Menu URL is incorrect");
    }

    @Test(priority = 3)
    public void verifyContextMenuAlertText() {
        ContextMenuPage page = new ContextMenuPage();

        String alertText = page.rightClickAndGetAlertText();

        Assert.assertEquals(
                alertText,
                "You selected a context menu",
                "Context menu alert text is incorrect");
    }
}
