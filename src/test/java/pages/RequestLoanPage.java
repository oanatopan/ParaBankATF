package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class RequestLoanPage extends BasePage {

    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "amount")
    public WebElement amountElement;

    @FindBy(id = "downPayment")
    public WebElement downPaymentElement;

    @FindBy(xpath = "//input[@value='Apply Now']")
    public WebElement applyNowButtonElement;

    @FindBy(id = "loanStatus")
    public WebElement loanStatusElement;

    public void loanProcess() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(amountElement));

        elementsMethods.fillElement(amountElement, "100");
        LogUtility.infoLog("The user fills loan amount field with value: 100");

        elementsMethods.fillElement(downPaymentElement, "10");
        LogUtility.infoLog("The user fills down payment field with value: 10");

        elementsMethods.clickElement(applyNowButtonElement);
        LogUtility.infoLog("The user clicks on Apply Now button");
    }

    public String getLoanStatus() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(loanStatusElement));
        return elementsMethods.getElementText(loanStatusElement);
    }
}