package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAccountPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public SelectMethods selectMethods;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        selectMethods = new SelectMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "type")
    public WebElement accountTypeDropdownElement;

    @FindBy(xpath = "//select[@id='fromAccountId']/option")
    public WebElement fromAccountOptionElement;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButtonElement;

    @FindBy(id = "openAccountResult")
    public WebElement openAccountResultElement;

    @FindBy(id = "newAccountId")
    public WebElement newAccountIdElement;

    public void openAccountProcess() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(accountTypeDropdownElement));

        selectMethods.selectByVisibleText(accountTypeDropdownElement, "SAVINGS");
        System.out.println("The user selects the SAVINGS account type.");

        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(fromAccountOptionElement));
        String fromAccountOptionValue = elementsMethods.getElementText(fromAccountOptionElement);
        System.out.println("The user sees the From Account dropdown loaded with: " + fromAccountOptionValue);

        elementsMethods.clickElement(openNewAccountButtonElement);
        System.out.println("The user clicks the Open New Account button.");
    }

    public String getFromAccountOptionText() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(fromAccountOptionElement));
        return elementsMethods.getElementText(fromAccountOptionElement);
    }

    public String getNewAccountId() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(openAccountResultElement));
        return elementsMethods.getElementText(newAccountIdElement);
    }
}