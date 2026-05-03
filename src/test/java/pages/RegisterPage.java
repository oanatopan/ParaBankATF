package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RegisterPage extends BasePage{

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
        System.out.println("The user fills in the First Name field.");

        elementsMethods.fillElement(lastNameElement, "Topan");
        System.out.println("The user fills in the Last Name field.");

        elementsMethods.fillElement(streetElement, "Republicii");
        System.out.println("The user fills in the Street field.");

        elementsMethods.fillElement(cityElement, "Baia Mare");
        System.out.println("The user fills in the City field.");

        elementsMethods.fillElement(stateElement, "Romania");
        System.out.println("The user fills in the State field.");

        elementsMethods.fillElement(zipElement, "123456");
        System.out.println("The user fills in the Zip Code field.");

        elementsMethods.fillElement(phoneElement, "0722000000");
        System.out.println("The user fills in the Phone field.");

        elementsMethods.fillElement(ssnElement, "123-45-678");
        System.out.println("The user fills in the SSN field.");

        elementsMethods.fillElement(usernameElement, usernameValue);
        System.out.println("The user fills in the Username field.");

        elementsMethods.fillElement(passwordElement, "Parola123!");
        System.out.println("The user fills in the Password field.");

        elementsMethods.fillElement(confirmPasswordElement, "Parola123!");
        System.out.println("The user fills in the Confirm Password field.");

        elementsMethods.clickElement(registerButtonElement);
        System.out.println("The user clicks the Register button.");
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