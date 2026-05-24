package pages;

import modelObject.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement usernameElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButtonElement;

    @FindBy(linkText = "Log Out")
    private WebElement logOutElement;

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement errorTitleElement;

    public void loginInvalidProcess(LoginModel testData) {
        elementsMethods.fillElement(usernameElement, testData.getInvalidUsername());
        logStep("The user fills in the username field with value: " + testData.getInvalidUsername());

        elementsMethods.fillElement(passwordElement, testData.getInvalidPassword());
        logStep("The user fills in the password field");

        elementsMethods.clickJS(loginButtonElement);
        logStep("The user clicks on the Log In button");
    }

    public void loginValidProcess(String username, String password) {
        elementsMethods.waitVisibleElement(usernameElement);

        elementsMethods.fillElement(usernameElement, username);
        logStep("The user fills in the username field with value: " + username);

        elementsMethods.fillElement(passwordElement, password);
        logStep("The user fills in the password field");

        elementsMethods.clickElement(loginButtonElement);
        logStep("The user clicks on the Log In button");

        elementsMethods.waitVisibleElement(logOutElement);
        logStep("Login successful - menu is visible");
    }

    public void clickLogOut() {
        elementsMethods.waitVisibleElement(logOutElement);
        elementsMethods.clickElement(logOutElement);
        logStep("The user clicks on the Log Out link");
    }

    public String getErrorTitle() {
        elementsMethods.waitVisibleElement(errorTitleElement);
        return elementsMethods.getElementText(errorTitleElement);
    }

    public String getLogOutText() {
        elementsMethods.waitVisibleElement(logOutElement);
        return elementsMethods.getElementText(logOutElement);
    }

    public String getLoginButtonValue() {
        elementsMethods.waitVisibleElement(loginButtonElement);
        return loginButtonElement.getAttribute("value");
    }
}