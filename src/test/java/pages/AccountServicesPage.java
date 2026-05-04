package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class AccountServicesPage extends BasePage {

    public AccountServicesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Open New Account")
    public WebElement openNewAccountLinkElement;

    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverviewLinkElement;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFundsLinkElement;

    @FindBy(linkText = "Bill Pay")
    public WebElement billPayLinkElement;

    @FindBy(linkText = "Request Loan")
    public WebElement requestLoanLinkElement;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLinkElement;

    public void clickOpenNewAccount() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(openNewAccountLinkElement));
        elementsMethods.clickElement(openNewAccountLinkElement);
        LogUtility.infoLog("The user clicks on Open New Account link");
    }

    public void clickAccountsOverview() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(accountsOverviewLinkElement));
        elementsMethods.clickElement(accountsOverviewLinkElement);
        LogUtility.infoLog("The user clicks on Accounts Overview link");
    }

    public void clickTransferFunds() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(transferFundsLinkElement));
        elementsMethods.clickElement(transferFundsLinkElement);
        LogUtility.infoLog("The user clicks on Transfer Funds link");
    }

    public void clickBillPay() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(billPayLinkElement));
        elementsMethods.clickElement(billPayLinkElement);
        LogUtility.infoLog("The user clicks on Bill Pay link");
    }

    public void clickRequestLoan() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(requestLoanLinkElement));
        elementsMethods.clickElement(requestLoanLinkElement);
        LogUtility.infoLog("The user clicks on Request Loan link");
    }

    public void clickLogOut() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(logOutLinkElement));
        elementsMethods.clickElement(logOutLinkElement);
        LogUtility.infoLog("The user clicks on Log Out link");
    }
}