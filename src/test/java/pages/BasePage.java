package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
}