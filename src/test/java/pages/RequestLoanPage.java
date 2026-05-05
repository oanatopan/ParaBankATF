package pages;

import modelObject.RequestLoanModel;
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

    public void loanProcess(RequestLoanModel testData) {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(amountElement));

        elementsMethods.fillElement(amountElement, testData.getLoanAmount());
        LogUtility.infoLog("The user fills loan amount field with value: " + testData.getLoanAmount());

        elementsMethods.fillElement(downPaymentElement, testData.getDownPayment());
        LogUtility.infoLog("The user fills down payment field with value: " + testData.getDownPayment());

        elementsMethods.clickElement(applyNowButtonElement);
        LogUtility.infoLog("The user clicks on Apply Now button");
    }

    public String getLoanStatus() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(loanStatusElement));
        return elementsMethods.getElementText(loanStatusElement);
    }
}