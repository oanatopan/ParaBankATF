package pages;

import modelObject.TransferFundsModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        logStep("The user selects the first available account from the From Account dropdown");

        selectMethods.selectByIndex(toAccountDropdownElement, 1);
        logStep("The user selects the second available account from the To Account dropdown");

        elementsMethods.fillElement(amountElement, testData.getAmount());
        logStep("The user fills in the amount field with value: " + testData.getAmount());

        elementsMethods.clickElement(transferButtonElement);
        logStep("The user clicks on the Transfer button");
    }

    public String getTransferResult() {
        elementsMethods.waitVisibleElement(resultElement);
        String transferResult = elementsMethods.getElementText(resultElement);
        logStep("The user sees the transfer result: " + transferResult);
        return transferResult;
    }
}