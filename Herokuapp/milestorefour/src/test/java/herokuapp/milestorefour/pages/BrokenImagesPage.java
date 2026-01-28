package herokuapp.milestorefour.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class BrokenImagesPage {

    private WebDriver driver;

    public BrokenImagesPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openBrokenImagesPage();
    }

    // All images on page
    @FindBy(tagName = "img")
    private List<WebElement> images;

    // Navigate to page
    public void openBrokenImagesPage() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        WaitUtil.defaultWait();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public int getTotalImagesCount() {
        return images.size();
    }

    // Check broken images using HTTP status
    public int getBrokenImagesCount() {
        int brokenImages = 0;

        for (WebElement img : images) {
            try {
                String imgURL = img.getAttribute("src");

                HttpURLConnection connection =
                        (HttpURLConnection) new URL(imgURL).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                if (connection.getResponseCode() != 200) {
                    brokenImages++;
                }

            } catch (Exception e) {
                brokenImages++;
            }
        }
        return brokenImages;
    }
}
