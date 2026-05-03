package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransferFundsPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public SelectMethods selectMethods;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        selectMethods = new SelectMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdownElement;

    @FindBy(id = "toAccountId")
    public WebElement toAccountDropdownElement;

    @FindBy(id = "amount")
    public WebElement amountElement;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transferButtonElement;

    @FindBy(id = "showResult")
    public WebElement resultElement;

    public void transferProcess() {
        WebElement fromAccountDropdown = elementsMethods.waitClickableElement(fromAccountDropdownElement);
        selectMethods.selectByIndex(fromAccountDropdown, 0);
        System.out.println("The user selects the source account from the dropdown.");

        selectMethods.selectByIndex(toAccountDropdownElement, 1);
        System.out.println("The user selects the destination account from the dropdown.");

        elementsMethods.fillElement(amountElement, "100");
        System.out.println("The user fills in the transfer amount.");

        elementsMethods.clickElement(transferButtonElement);
        System.out.println("The user clicks the Transfer button.");
    }

    public String getTransferResult() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(resultElement));
        return elementsMethods.getElementText(resultElement);
    }
}