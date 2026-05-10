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
    private WebElement fromAccountDropdownElement;

    @FindBy(id = "toAccountId")
    private WebElement toAccountDropdownElement;

    @FindBy(id = "amount")
    private WebElement amountElement;

    @FindBy(xpath = "//input[@value='Transfer']")
    private WebElement transferButtonElement;

    @FindBy(id = "showResult")
    private WebElement resultElement;

    public void transferProcess(TransferFundsModel testData) {
        WebElement fromAccountDropdown = elementsMethods.waitClickableElement(fromAccountDropdownElement);
        selectMethods.selectByIndex(fromAccountDropdown, 0);
        LogUtility.infoLog("The user selects the first available account from the From Account dropdown");

        selectMethods.selectByIndex(toAccountDropdownElement, 1);
        LogUtility.infoLog("The user selects the second available account from the To Account dropdown");

        elementsMethods.fillElement(amountElement, testData.getAmount());
        LogUtility.infoLog("The user fills in the amount field with value: " + testData.getAmount());

        elementsMethods.clickElement(transferButtonElement);
        LogUtility.infoLog("The user clicks on the Transfer button");
    }

    public String getTransferResult() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(resultElement));
        String transferResult = elementsMethods.getElementText(resultElement);
        LogUtility.infoLog("The user sees the transfer result: " + transferResult);
        return transferResult;
    }
}