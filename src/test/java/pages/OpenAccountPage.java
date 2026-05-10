package pages;

import modelObject.OpenAccountModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtility;

public class OpenAccountPage extends BasePage {

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "type")
    private WebElement accountTypeDropdownElement;

    @FindBy(xpath = "//select[@id='fromAccountId']/option")
    private WebElement fromAccountOptionElement;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountButtonElement;

    @FindBy(id = "openAccountResult")
    private WebElement openAccountResultElement;

    @FindBy(id = "newAccountId")
    private WebElement newAccountIdElement;

    public void openAccountProcess(OpenAccountModel testData) {
        elementsMethods.waitVisibleElement(accountTypeDropdownElement);

        selectMethods.selectByVisibleText(accountTypeDropdownElement, testData.getAccountType());
        LogUtility.infoLog("The user selects " + testData.getAccountType() + " from the account type dropdown");

        elementsMethods.waitVisibleElement(fromAccountOptionElement);
        String fromAccountOptionValue = elementsMethods.getElementText(fromAccountOptionElement);
        LogUtility.infoLog("The user sees the From Account dropdown loaded with value: " + fromAccountOptionValue);

        elementsMethods.clickElement(openNewAccountButtonElement);
        LogUtility.infoLog("The user clicks on the Open New Account button");
    }

    public String getFromAccountOptionText() {
        elementsMethods.waitVisibleElement(fromAccountOptionElement);
        return elementsMethods.getElementText(fromAccountOptionElement);
    }

    public String getNewAccountId() {
        elementsMethods.waitVisibleElement(openAccountResultElement);
        String newAccountId = elementsMethods.getElementText(newAccountIdElement);
        LogUtility.infoLog("The user sees the new account ID: " + newAccountId);
        return newAccountId;
    }
}