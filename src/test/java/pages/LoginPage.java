package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
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

    public void loginInvalidProcess() {
        elementsMethods.fillElement(usernameElement, "utilizator_inexistent");
        System.out.println("The user fills in the Username field.");

        elementsMethods.fillElement(passwordElement, "parola123");
        System.out.println("The user fills in the Password field.");

        elementsMethods.clickJS(loginButtonElement);
        System.out.println("The user clicks the Log In button.");
    }

    public void loginValidProcess(String username, String password) {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(usernameElement));

        elementsMethods.fillElement(usernameElement, username);
        System.out.println("The user fills in the Login Username field.");

        elementsMethods.fillElement(passwordElement, password);
        System.out.println("The user fills in the Login Password field.");

        elementsMethods.clickElement(loginButtonElement);
        System.out.println("The user clicks the Log In button.");
    }

    public void clickLogOut() {
        elementsMethods.wait.until(ExpectedConditions.elementToBeClickable(logOutElement));
        elementsMethods.clickElement(logOutElement);
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