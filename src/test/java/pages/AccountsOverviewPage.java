package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class AccountsOverviewPage extends BasePage {

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "accountTable")
    private WebElement accountTableElement;

    @FindBy(xpath = "//table[@id='accountTable']//a")
    private WebElement firstAccountLinkElement;

    public String getAccountTableText() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(accountTableElement));
        return elementsMethods.getElementText(accountTableElement);
    }

    public void clickFirstAccount() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(firstAccountLinkElement));
        elementsMethods.clickElement(firstAccountLinkElement);
        LogUtility.infoLog("The user clicks on first account link");
    }
}