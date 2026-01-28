package herokuapp.milestorefour.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class DisappearingElementsPage {

    private WebDriver driver;

    public DisappearingElementsPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openDisappearingElementsPage();
    }

    // Menu items (Gallery may disappear)
    @FindBy(css = "ul li a")
    private List<WebElement> menuItems;

    // Navigate
    public void openDisappearingElementsPage() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Menu validations
    public int getMenuItemCount() {
        return menuItems.size();
    }

    public boolean isMenuItemPresent(String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
}
