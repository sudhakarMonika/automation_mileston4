package herokuapp.milestorefour.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class ContextMenuPage {

    private WebDriver driver;

    public ContextMenuPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openContextMenuPage();
    }

    // Context menu box
    @FindBy(id = "hot-spot")
    private WebElement hotSpot;

    // Navigate
    public void openContextMenuPage() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Right click action
    public String rightClickAndGetAlertText() {
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();
        WaitUtil.defaultWait();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
