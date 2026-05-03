package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountServicesPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public AccountServicesPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
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
    }

    public void clickAccountsOverview() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(accountsOverviewLinkElement));
        elementsMethods.clickElement(accountsOverviewLinkElement);
    }

    public void clickTransferFunds() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(transferFundsLinkElement));
        elementsMethods.clickElement(transferFundsLinkElement);
    }

    public void clickBillPay() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(billPayLinkElement));
        elementsMethods.clickElement(billPayLinkElement);
    }

    public void clickRequestLoan() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(requestLoanLinkElement));
        elementsMethods.clickElement(requestLoanLinkElement);
    }

    public void clickLogOut() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(logOutLinkElement));
        elementsMethods.clickElement(logOutLinkElement);
    }
}