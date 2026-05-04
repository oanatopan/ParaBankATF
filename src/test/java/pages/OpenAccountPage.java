package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class OpenAccountPage extends BasePage {

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "type")
    public WebElement accountTypeDropdownElement;

    @FindBy(xpath = "//select[@id='fromAccountId']/option")
    public WebElement fromAccountOptionElement;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButtonElement;

    @FindBy(id = "openAccountResult")
    public WebElement openAccountResultElement;

    @FindBy(id = "newAccountId")
    public WebElement newAccountIdElement;

    public void openAccountProcess() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(accountTypeDropdownElement));

        selectMethods.selectByVisibleText(accountTypeDropdownElement, "SAVINGS");
        LogUtility.infoLog("The user selects SAVINGS from account type dropdown");

        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(fromAccountOptionElement));
        String fromAccountOptionValue = elementsMethods.getElementText(fromAccountOptionElement);
        LogUtility.infoLog("The user sees From Account dropdown loaded with value: " + fromAccountOptionValue);

        elementsMethods.clickElement(openNewAccountButtonElement);
        LogUtility.infoLog("The user clicks on Open New Account button");
    }

    public String getFromAccountOptionText() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(fromAccountOptionElement));
        return elementsMethods.getElementText(fromAccountOptionElement);
    }

    public String getNewAccountId() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(openAccountResultElement));
        return elementsMethods.getElementText(newAccountIdElement);
    }
}