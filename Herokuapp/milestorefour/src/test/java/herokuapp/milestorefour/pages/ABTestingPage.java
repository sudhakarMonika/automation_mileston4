package herokuapp.milestorefour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class ABTestingPage {

    private WebDriver driver;

    public ABTestingPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        abTesting();
    }
    
    @FindBy(xpath="//a[text()=\"A/B Testing\"]")
    private WebElement abTesting;

    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(id = "content")
    private WebElement content;

    public void abTesting() {
    	abTesting.click();
    	WaitUtil.defaultWait();
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
   

    public String getHeaderText() {
        return header.getText();
    }

    public boolean isContentDisplayed() {
        return content.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
