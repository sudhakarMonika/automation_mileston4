package herokuapp.milestorefour.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import herokuapp.milestorefour.utility.DriverFactory;
import herokuapp.milestorefour.utility.WaitUtil;

public class DragAndDropPage {

    private WebDriver driver;

    public DragAndDropPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        openDragAndDropPage();
    }

    // Draggable columns
    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    // Navigate
    public void openDragAndDropPage() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WaitUtil.defaultWait();
    }

    // Page info
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // JavaScript based drag and drop (reliable)
    public void dragAToB() {
        String script =
                "function createEvent(typeOfEvent) {" +
                " var event = document.createEvent(\"CustomEvent\");" +
                " event.initCustomEvent(typeOfEvent, true, true, null);" +
                " event.dataTransfer = {" +
                "  data: {}," +
                "  setData: function(key, value) { this.data[key] = value; }," +
                "  getData: function(key) { return this.data[key]; }" +
                " };" +
                " return event;" +
                "}" +
                "function dispatchEvent(element, event, transferData) {" +
                " if (transferData !== undefined) {" +
                "  event.dataTransfer = transferData;" +
                " }" +
                " if (element.dispatchEvent) {" +
                "  element.dispatchEvent(event);" +
                " } else if (element.fireEvent) {" +
                "  element.fireEvent(\"on\" + event.type, event);" +
                " }" +
                "}" +
                "function dragAndDrop(element, target) {" +
                " var dragStartEvent = createEvent('dragstart');" +
                " dispatchEvent(element, dragStartEvent);" +
                " var dropEvent = createEvent('drop');" +
                " dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);" +
                " var dragEndEvent = createEvent('dragend');" +
                " dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);" +
                "}" +
                "dragAndDrop(arguments[0], arguments[1]);";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, columnA, columnB);

        WaitUtil.defaultWait();
    }

    // Validation
    public String getColumnAText() {
        return columnA.getText();
    }

    public String getColumnBText() {
        return columnB.getText();
    }
}
