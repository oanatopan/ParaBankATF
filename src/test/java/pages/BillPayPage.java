package pages;

import modelObject.BillPayModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillPayPage extends BasePage {

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "payee.name")
    private WebElement payeeNameElement;

    @FindBy(name = "payee.address.street")
    private WebElement payeeStreetElement;

    @FindBy(name = "payee.address.city")
    private WebElement payeeCityElement;

    @FindBy(name = "payee.address.state")
    private WebElement payeeStateElement;

    @FindBy(name = "payee.address.zipCode")
    private WebElement payeeZipElement;

    @FindBy(name = "payee.phoneNumber")
    private WebElement payeePhoneElement;

    @FindBy(name = "payee.accountNumber")
    private WebElement accountNumberElement;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccountElement;

    @FindBy(name = "amount")
    private WebElement amountElement;

    @FindBy(name = "fromAccountId")
    private WebElement fromAccountDropdownElement;

    @FindBy(xpath = "//input[@value='Send Payment']")
    private WebElement sendPaymentButtonElement;

    @FindBy(id = "billpayResult")
    private WebElement billPayResultElement;

    public void billPayProcess(BillPayModel testData) {
        elementsMethods.fillElement(payeeNameElement, testData.getPayeeName());
        logStep("The user fills in the payee name field with value: " + testData.getPayeeName());

        elementsMethods.fillElement(payeeStreetElement, testData.getAddress());
        logStep("The user fills in the payee street field with value: " + testData.getAddress());

        elementsMethods.fillElement(payeeCityElement, testData.getCity());
        logStep("The user fills in the payee city field with value: " + testData.getCity());

        elementsMethods.fillElement(payeeStateElement, testData.getState());
        logStep("The user fills in the payee state field with value: " + testData.getState());

        elementsMethods.fillElement(payeeZipElement, testData.getZipCode());
        logStep("The user fills in the payee zip code field with value: " + testData.getZipCode());

        elementsMethods.fillElement(payeePhoneElement, testData.getPhone());
        logStep("The user fills in the payee phone number field with value: " + testData.getPhone());

        elementsMethods.fillElement(accountNumberElement, testData.getAccountNumber());
        logStep("The user fills in the account number field");

        elementsMethods.fillElement(verifyAccountElement, testData.getVerifyAccount());
        logStep("The user fills in the verify account field");

        elementsMethods.fillElement(amountElement, testData.getAmount());
        logStep("The user fills in the amount field with value: " + testData.getAmount());

        selectMethods.selectByIndex(fromAccountDropdownElement, 0);
        logStep("The user selects the first available account from the source account dropdown");

        elementsMethods.clickElement(sendPaymentButtonElement);
        logStep("The user clicks on the Send Payment button");
    }

    public String getBillPayResult() {
        elementsMethods.waitVisibleElement(billPayResultElement);
        String billPayResult = elementsMethods.getElementText(billPayResultElement);
        logStep("The user sees the bill pay result: " + billPayResult);
        return billPayResult;
    }
}