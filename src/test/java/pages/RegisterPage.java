package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer.firstName")
    public WebElement firstNameElement;

    @FindBy(id = "customer.lastName")
    public WebElement lastNameElement;

    @FindBy(id = "customer.address.street")
    public WebElement streetElement;

    @FindBy(id = "customer.address.city")
    public WebElement cityElement;

    @FindBy(id = "customer.address.state")
    public WebElement stateElement;

    @FindBy(id = "customer.address.zipCode")
    public WebElement zipElement;

    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneElement;

    @FindBy(id = "customer.ssn")
    public WebElement ssnElement;

    @FindBy(id = "customer.username")
    public WebElement usernameElement;

    @FindBy(id = "customer.password")
    public WebElement passwordElement;

    @FindBy(id = "repeatedPassword")
    public WebElement confirmPasswordElement;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButtonElement;

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    public WebElement successMessageElement;

    public void registerProcess(String usernameValue) {
        elementsMethods.fillElement(firstNameElement, "Oana");
        LogUtility.infoLog("The user fills first name field with value: Oana");

        elementsMethods.fillElement(lastNameElement, "Topan");
        LogUtility.infoLog("The user fills last name field with value: Topan");

        elementsMethods.fillElement(streetElement, "Republicii");
        LogUtility.infoLog("The user fills street field with value: Republicii");

        elementsMethods.fillElement(cityElement, "Baia Mare");
        LogUtility.infoLog("The user fills city field with value: Baia Mare");

        elementsMethods.fillElement(stateElement, "Romania");
        LogUtility.infoLog("The user fills state field with value: Romania");

        elementsMethods.fillElement(zipElement, "123456");
        LogUtility.infoLog("The user fills zip code field with value: 123456");

        elementsMethods.fillElement(phoneElement, "0722000000");
        LogUtility.infoLog("The user fills phone number field with value: 0722000000");

        elementsMethods.fillElement(ssnElement, "123-45-678");
        LogUtility.infoLog("The user fills SSN field with value: 123-45-678");

        elementsMethods.fillElement(usernameElement, usernameValue);
        LogUtility.infoLog("The user fills username field with value: " + usernameValue);

        elementsMethods.fillElement(passwordElement, "Parola123!");
        LogUtility.infoLog("The user fills password field");

        elementsMethods.fillElement(confirmPasswordElement, "Parola123!");
        LogUtility.infoLog("The user fills confirm password field");

        elementsMethods.clickElement(registerButtonElement);
        LogUtility.infoLog("The user clicks on Register button");
    }

    public String getRegistrationError() {
        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[contains(@class,'error')]"));
        if (!errorMessage.isEmpty()) {
            return errorMessage.get(0).getText();
        }
        return "";
    }

    public String getSuccessMessage() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(successMessageElement));
        return elementsMethods.getElementText(successMessageElement);
    }
}