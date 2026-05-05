package pages;

import modelObject.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    public WebElement usernameElement;

    @FindBy(name = "password")
    public WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButtonElement;

    @FindBy(linkText = "Log Out")
    public WebElement logOutElement;

    @FindBy(xpath = "//h1[@class='title']")
    public WebElement errorTitleElement;

    public void loginInvalidProcess(LoginModel testData) {
        elementsMethods.fillElement(usernameElement, testData.getInvalidUsername());
        LogUtility.infoLog("The user fills username field with value: " + testData.getInvalidUsername());

        elementsMethods.fillElement(passwordElement, testData.getInvalidPassword());
        LogUtility.infoLog("The user fills password field");

        elementsMethods.clickJS(loginButtonElement);
        LogUtility.infoLog("The user clicks on Log In button");
    }

    public void loginValidProcess(String username, String password) {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(usernameElement));

        elementsMethods.fillElement(usernameElement, username);
        LogUtility.infoLog("The user fills username field with value: " + username);

        elementsMethods.fillElement(passwordElement, password);
        LogUtility.infoLog("The user fills password field");

        elementsMethods.clickElement(loginButtonElement);
        LogUtility.infoLog("The user clicks on Log In button");
    }

    public void clickLogOut() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(logOutElement));
        elementsMethods.clickElement(logOutElement);
        LogUtility.infoLog("The user clicks on Log Out link");
    }

    public String getErrorTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(errorTitleElement));
        return elementsMethods.getElementText(errorTitleElement);
    }

    public String getLogOutText() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(logOutElement));
        return elementsMethods.getElementText(logOutElement);
    }

    public String getLoginButtonValue() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(loginButtonElement));
        return loginButtonElement.getAttribute("value");
    }
}