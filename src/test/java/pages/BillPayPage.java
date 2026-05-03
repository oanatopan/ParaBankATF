package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillPayPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public SelectMethods selectMethods;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        selectMethods = new SelectMethods(this.driver);
        PageFactory.initElements(this.driver, this);
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
        System.out.println("The user fills in the Payee Name field.");

        elementsMethods.fillElement(payeeStreetElement, "Str. Energiei 10");
        System.out.println("The user fills in the Payee Street field.");

        elementsMethods.fillElement(payeeCityElement, "Baia Mare");
        System.out.println("The user fills in the Payee City field.");

        elementsMethods.fillElement(payeeStateElement, "Maramures");
        System.out.println("The user fills in the Payee State field.");

        elementsMethods.fillElement(payeeZipElement, "430001");
        System.out.println("The user fills in the Payee Zip Code field.");

        elementsMethods.fillElement(payeePhoneElement, "0744111222");
        System.out.println("The user fills in the Payee Phone field.");

        elementsMethods.fillElement(accountNumberElement, "12345");
        System.out.println("The user fills in the Account Number field.");

        elementsMethods.fillElement(verifyAccountElement, "12345");
        System.out.println("The user fills in the Verify Account field.");

        elementsMethods.fillElement(amountElement, "50");
        System.out.println("The user fills in the Amount field.");

        selectMethods.selectByIndex(fromAccountDropdownElement, 0);
        System.out.println("The user selects the source account from the dropdown.");

        elementsMethods.clickElement(sendPaymentButtonElement);
        System.out.println("The user clicks the Send Payment button.");
    }

    public String getBillPayResult() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(billPayResultElement));
        return elementsMethods.getElementText(billPayResultElement);
    }
}