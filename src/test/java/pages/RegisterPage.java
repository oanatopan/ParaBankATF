package pages;

import modelObject.RegisterModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstNameElement;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameElement;

    @FindBy(id = "customer.address.street")
    private WebElement streetElement;

    @FindBy(id = "customer.address.city")
    private WebElement cityElement;

    @FindBy(id = "customer.address.state")
    private WebElement stateElement;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipElement;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneElement;

    @FindBy(id = "customer.ssn")
    private WebElement ssnElement;

    @FindBy(id = "customer.username")
    private WebElement usernameElement;

    @FindBy(id = "customer.password")
    private WebElement passwordElement;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordElement;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButtonElement;

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    private WebElement successMessageElement;

    public void registerProcess(String usernameValue, RegisterModel testData) {
        elementsMethods.waitVisibleElement(firstNameElement);

        elementsMethods.fillElement(firstNameElement, testData.getFirstName());
        logStep("The user fills in the first name field with value: " + testData.getFirstName());

        elementsMethods.fillElement(lastNameElement, testData.getLastName());
        logStep("The user fills in the last name field with value: " + testData.getLastName());

        elementsMethods.fillElement(streetElement, testData.getAddress());
        logStep("The user fills in the street field with value: " + testData.getAddress());

        elementsMethods.fillElement(cityElement, testData.getCity());
        logStep("The user fills in the city field with value: " + testData.getCity());

        elementsMethods.fillElement(stateElement, testData.getState());
        logStep("The user fills in the state field with value: " + testData.getState());

        elementsMethods.fillElement(zipElement, testData.getZipCode());
        logStep("The user fills in the zip code field with value: " + testData.getZipCode());

        elementsMethods.fillElement(phoneElement, testData.getPhone());
        logStep("The user fills in the phone number field with value: " + testData.getPhone());

        elementsMethods.fillElement(ssnElement, testData.getSsn());
        logStep("The user fills in the SSN field");

        elementsMethods.fillElement(usernameElement, usernameValue);
        logStep("The user fills in the username field with value: " + usernameValue);

        elementsMethods.fillElement(passwordElement, testData.getPassword());
        logStep("The user fills in the password field");

        elementsMethods.fillElement(confirmPasswordElement, testData.getPassword());
        logStep("The user fills in the confirm password field");

        elementsMethods.clickElement(registerButtonElement);
        logStep("The user clicks on the Register button");
    }

    public String getRegistrationError() {
        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[contains(@class,'error')]"));
        if (!errorMessage.isEmpty()) {
            return errorMessage.get(0).getText();
        }
        return "";
    }

    public String getSuccessMessage() {
        elementsMethods.waitVisibleElement(successMessageElement);
        return elementsMethods.getElementText(successMessageElement);
    }
}