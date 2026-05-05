package pages;

import modelObject.TransferFundsModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class TransferFundsPage extends BasePage {

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdownElement;

    @FindBy(id = "toAccountId")
    public WebElement toAccountDropdownElement;

    @FindBy(id = "amount")
    public WebElement amountElement;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transferButtonElement;

    @FindBy(id = "showResult")
    public WebElement resultElement;

    public void transferProcess(TransferFundsModel testData) {
        WebElement fromAccountDropdown = elementsMethods.waitClickableElement(fromAccountDropdownElement);
        selectMethods.selectByIndex(fromAccountDropdown, 0);
        LogUtility.infoLog("The user selects first available account from From Account dropdown");

        selectMethods.selectByIndex(toAccountDropdownElement, 1);
        LogUtility.infoLog("The user selects second available account from To Account dropdown");

        elementsMethods.fillElement(amountElement, testData.getAmount());
        LogUtility.infoLog("The user fills amount field with value: " + testData.getAmount());

        elementsMethods.clickElement(transferButtonElement);
        LogUtility.infoLog("The user clicks on Transfer button");
    }

    public String getTransferResult() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(resultElement));
        return elementsMethods.getElementText(resultElement);
    }
}