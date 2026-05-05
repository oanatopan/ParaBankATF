package pages;

import modelObject.BillPayModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class BillPayPage extends BasePage {

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "payee.name")
    public WebElement payeeNameElement;

    @FindBy(name = "payee.address.street")
    public WebElement payeeStreetElement;

    @FindBy(name = "payee.address.city")
    public WebElement payeeCityElement;

    @FindBy(name = "payee.address.state")
    public WebElement payeeStateElement;

    @FindBy(name = "payee.address.zipCode")
    public WebElement payeeZipElement;

    @FindBy(name = "payee.phoneNumber")
    public WebElement payeePhoneElement;

    @FindBy(name = "payee.accountNumber")
    public WebElement accountNumberElement;

    @FindBy(name = "verifyAccount")
    public WebElement verifyAccountElement;

    @FindBy(name = "amount")
    public WebElement amountElement;

    @FindBy(name = "fromAccountId")
    public WebElement fromAccountDropdownElement;

    @FindBy(xpath = "//input[@value='Send Payment']")
    public WebElement sendPaymentButtonElement;

    @FindBy(id = "billpayResult")
    public WebElement billPayResultElement;

    public void billPayProcess(BillPayModel testData) {
        elementsMethods.fillElement(payeeNameElement, testData.getPayeeName());
        LogUtility.infoLog("The user fills payee name field with value: " + testData.getPayeeName());

        elementsMethods.fillElement(payeeStreetElement, testData.getAddress());
        LogUtility.infoLog("The user fills payee street field with value: " + testData.getAddress());

        elementsMethods.fillElement(payeeCityElement, testData.getCity());
        LogUtility.infoLog("The user fills payee city field with value: " + testData.getCity());

        elementsMethods.fillElement(payeeStateElement, testData.getState());
        LogUtility.infoLog("The user fills payee state field with value: " + testData.getState());

        elementsMethods.fillElement(payeeZipElement, testData.getZipCode());
        LogUtility.infoLog("The user fills payee zip code field with value: " + testData.getZipCode());

        elementsMethods.fillElement(payeePhoneElement, testData.getPhone());
        LogUtility.infoLog("The user fills payee phone number field with value: " + testData.getPhone());

        elementsMethods.fillElement(accountNumberElement, testData.getAccountNumber());
        LogUtility.infoLog("The user fills account number field");

        elementsMethods.fillElement(verifyAccountElement, testData.getVerifyAccount());
        LogUtility.infoLog("The user fills verify account field");

        elementsMethods.fillElement(amountElement, testData.getAmount());
        LogUtility.infoLog("The user fills amount field with value: " + testData.getAmount());

        selectMethods.selectByIndex(fromAccountDropdownElement, 0);
        LogUtility.infoLog("The user selects first available account from source account dropdown");

        elementsMethods.clickElement(sendPaymentButtonElement);
        LogUtility.infoLog("The user clicks on Send Payment button");
    }

    public String getBillPayResult() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(billPayResultElement));
        return elementsMethods.getElementText(billPayResultElement);
    }
}