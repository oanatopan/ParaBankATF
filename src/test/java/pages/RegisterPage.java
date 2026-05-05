package pages;

import modelObject.RegisterModel;
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

    public void registerProcess(String usernameValue, RegisterModel testData) {
        elementsMethods.fillElement(firstNameElement, testData.getFirstName());
        LogUtility.infoLog("The user fills first name field with value: " + testData.getFirstName());

        elementsMethods.fillElement(lastNameElement, testData.getLastName());
        LogUtility.infoLog("The user fills last name field with value: " + testData.getLastName());

        elementsMethods.fillElement(streetElement, testData.getAddress());
        LogUtility.infoLog("The user fills street field with value: " + testData.getAddress());

        elementsMethods.fillElement(cityElement, testData.getCity());
        LogUtility.infoLog("The user fills city field with value: " + testData.getCity());

        elementsMethods.fillElement(stateElement, testData.getState());
        LogUtility.infoLog("The user fills state field with value: " + testData.getState());

        elementsMethods.fillElement(zipElement, testData.getZipCode());
        LogUtility.infoLog("The user fills zip code field with value: " + testData.getZipCode());

        elementsMethods.fillElement(phoneElement, testData.getPhone());
        LogUtility.infoLog("The user fills phone number field with value: " + testData.getPhone());

        elementsMethods.fillElement(ssnElement, testData.getSsn());
        LogUtility.infoLog("The user fills SSN field");

        elementsMethods.fillElement(usernameElement, usernameValue);
        LogUtility.infoLog("The user fills username field with value: " + usernameValue);

        elementsMethods.fillElement(passwordElement, testData.getPassword());
        LogUtility.infoLog("The user fills password field");

        elementsMethods.fillElement(confirmPasswordElement, testData.getPassword());
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