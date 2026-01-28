package herokuapp.milestorefour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class DigestAuthPage {

    private WebDriver driver;

    public DigestAuthPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openDigestAuthPage();
    }

    // Success message paragraph
    @FindBy(tagName = "p")
    private WebElement successMessage;

    // Navigate using auth in URL (works for Herokuapp)
    public void openDigestAuthPage() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Validations
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
}
