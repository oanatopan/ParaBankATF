package pages;

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

    public void billPayProcess() {
        elementsMethods.fillElement(payeeNameElement, "Electrica SA");
        LogUtility.infoLog("The user fills payee name field with value: Electrica SA");

        elementsMethods.fillElement(payeeStreetElement, "Str. Energiei 10");
        LogUtility.infoLog("The user fills payee street field with value: Str. Energiei 10");

        elementsMethods.fillElement(payeeCityElement, "Baia Mare");
        LogUtility.infoLog("The user fills payee city field with value: Baia Mare");

        elementsMethods.fillElement(payeeStateElement, "Maramures");
        LogUtility.infoLog("The user fills payee state field with value: Maramures");

        elementsMethods.fillElement(payeeZipElement, "430001");
        LogUtility.infoLog("The user fills payee zip code field with value: 430001");

        elementsMethods.fillElement(payeePhoneElement, "0744111222");
        LogUtility.infoLog("The user fills payee phone number field with value: 0744111222");

        elementsMethods.fillElement(accountNumberElement, "12345");
        LogUtility.infoLog("The user fills account number field with value: 12345");

        elementsMethods.fillElement(verifyAccountElement, "12345");
        LogUtility.infoLog("The user fills verify account field with value: 12345");

        elementsMethods.fillElement(amountElement, "50");
        LogUtility.infoLog("The user fills amount field with value: 50");

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