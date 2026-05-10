package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtility;

public class AccountServicesPage extends BasePage {

    public AccountServicesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Open New Account")
    private WebElement openNewAccountLinkElement;

    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsOverviewLinkElement;

    @FindBy(linkText = "Transfer Funds")
    private WebElement transferFundsLinkElement;

    @FindBy(linkText = "Bill Pay")
    private WebElement billPayLinkElement;

    @FindBy(linkText = "Request Loan")
    private WebElement requestLoanLinkElement;

    @FindBy(linkText = "Log Out")
    private WebElement logOutLinkElement;

    public void clickOpenNewAccount() {
        elementsMethods.waitClickableElement(openNewAccountLinkElement);
        elementsMethods.clickElement(openNewAccountLinkElement);
        LogUtility.infoLog("The user clicks on the Open New Account link");
    }

    public void clickAccountsOverview() {
        elementsMethods.waitClickableElement(accountsOverviewLinkElement);
        elementsMethods.clickElement(accountsOverviewLinkElement);
        LogUtility.infoLog("The user clicks on the Accounts Overview link");
    }

    public void clickTransferFunds() {
        elementsMethods.waitClickableElement(transferFundsLinkElement);
        elementsMethods.clickElement(transferFundsLinkElement);
        LogUtility.infoLog("The user clicks on the Transfer Funds link");
    }

    public void clickBillPay() {
        elementsMethods.waitClickableElement(billPayLinkElement);
        elementsMethods.clickElement(billPayLinkElement);
        LogUtility.infoLog("The user clicks on the Bill Pay link");
    }

    public void clickRequestLoan() {
        elementsMethods.waitClickableElement(requestLoanLinkElement);
        elementsMethods.clickElement(requestLoanLinkElement);
        LogUtility.infoLog("The user clicks on the Request Loan link");
    }

    public void clickLogOut() {
        elementsMethods.waitClickableElement(logOutLinkElement);
        elementsMethods.clickElement(logOutLinkElement);
        LogUtility.infoLog("The user clicks on the Log Out link");
    }
}