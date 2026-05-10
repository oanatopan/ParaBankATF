package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsMethods {

    private WebDriver driver;
    public WebDriverWait wait;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element) {
        waitClickableElement(element);
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        waitVisibleElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickJS(WebElement element) {
        waitClickableElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public String getElementText(WebElement element) {
        waitVisibleElement(element);
        return element.getText();
    }
}