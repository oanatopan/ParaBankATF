package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        System.out.println("The user fills in the Loan Amount field.");

        elementsMethods.fillElement(downPaymentElement, "10");
        System.out.println("The user fills in the Down Payment field.");

        elementsMethods.clickElement(applyNowButtonElement);
        System.out.println("The user clicks the Apply Now button.");
    }

    public String getLoanStatus() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(loanStatusElement));
        return elementsMethods.getElementText(loanStatusElement);
    }
}