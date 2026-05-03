package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsOverviewPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "accountTable")
    public WebElement accountTableElement;

    @FindBy(xpath = "//table[@id='accountTable']//a")
    public WebElement firstAccountLinkElement;

    public String getAccountTableText() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(accountTableElement));
        return elementsMethods.getElementText(accountTableElement);
    }

    public void clickFirstAccount() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(firstAccountLinkElement));
        elementsMethods.clickElement(firstAccountLinkElement);
        System.out.println("The user clicks the first account link.");
    }
}