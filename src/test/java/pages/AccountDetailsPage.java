package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    public WebElement pageTitleElement;

    public String getPageTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(pageTitleElement));
        return elementsMethods.getElementText(pageTitleElement);
    }
}