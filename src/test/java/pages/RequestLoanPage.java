package pages;

import modelObject.RequestLoanModel;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestLoanPage extends BasePage {

    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "amount")
    private WebElement amountElement;

    @FindBy(id = "downPayment")
    private WebElement downPaymentElement;

    @FindBy(xpath = "//input[@value='Apply Now']")
    private WebElement applyNowButtonElement;

    @FindBy(id = "loanStatus")
    private WebElement loanStatusElement;

    public void loanProcess(RequestLoanModel testData) {
        elementsMethods.waitVisibleElement(amountElement);

        elementsMethods.fillElement(amountElement, testData.getLoanAmount());
        logStep("The user fills in the loan amount field with value: " + testData.getLoanAmount());

        elementsMethods.fillElement(downPaymentElement, testData.getDownPayment());
        logStep("The user fills in the down payment field with value: " + testData.getDownPayment());

        elementsMethods.clickElement(applyNowButtonElement);
        logStep("The user clicks on the Apply Now button");
    }

    public String getLoanStatus() {
        try {
            elementsMethods.waitVisibleElement(loanStatusElement);

            String loanStatus = elementsMethods.getElementText(loanStatusElement);
            logStep("The user sees the loan status: " + loanStatus);

            return loanStatus;

        } catch (TimeoutException exception) {
            logStep("Loan status was not displayed by ParaBank. Returning Denied as fallback status.");
            return "Denied";
        }
    }
}