package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtility;

public class BasePage {

    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected SelectMethods selectMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        selectMethods = new SelectMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    protected void logStep(String message) {
        LogUtility.infoLog(getClass().getSimpleName() + " -> " + message);
    }

    protected void logWarn(String message) {
        LogUtility.warnLog(getClass().getSimpleName() + " -> " + message);
    }

    protected void logError(String message) {
        LogUtility.errorLog(getClass().getSimpleName() + " -> " + message);
    }
}