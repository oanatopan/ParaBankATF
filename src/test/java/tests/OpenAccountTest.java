package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenAccountTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        WebElement firstNameElement = driver.findElement(By.id("customer.firstName"));
        String firstNameValue = "Oana";
        firstNameElement.sendKeys(firstNameValue);
        System.out.println("STEP 4: First Name field is filled.");

        WebElement lastNameElement = driver.findElement(By.id("customer.lastName"));
        String lastNameValue = "Topan";
        lastNameElement.sendKeys(lastNameValue);
        System.out.println("STEP 5: Last Name field is filled.");

        WebElement streetElement = driver.findElement(By.id("customer.address.street"));
        String streetValue = "Republicii";
        streetElement.sendKeys(streetValue);
        System.out.println("STEP 6: Street field is filled.");

        WebElement cityElement = driver.findElement(By.id("customer.address.city"));
        String cityValue = "Baia Mare";
        cityElement.sendKeys(cityValue);
        System.out.println("STEP 7: City field is filled.");

        WebElement stateElement = driver.findElement(By.id("customer.address.state"));
        String stateValue = "Romania";
        stateElement.sendKeys(stateValue);
        System.out.println("STEP 8: State field is filled.");

        WebElement zipElement = driver.findElement(By.id("customer.address.zipCode"));
        String zipValue = "123456";
        zipElement.sendKeys(zipValue);
        System.out.println("STEP 9: Zip Code field is filled.");

        WebElement phoneElement = driver.findElement(By.id("customer.phoneNumber"));
        String phoneValue = "0722000000";
        phoneElement.sendKeys(phoneValue);
        System.out.println("STEP 10: Phone field is filled.");

        WebElement ssnElement = driver.findElement(By.id("customer.ssn"));
        String ssnValue = "123-45-678";
        ssnElement.sendKeys(ssnValue);
        System.out.println("STEP 11: SSN field is filled.");

        WebElement usernameElement = driver.findElement(By.id("customer.username"));
        String usernameValue = "oana" + System.currentTimeMillis();
        usernameElement.sendKeys(usernameValue);
        System.out.println("STEP 12: Username field is filled.");

        WebElement passwordElement = driver.findElement(By.id("customer.password"));
        String passwordValue = "Parola123!";
        passwordElement.sendKeys(passwordValue);
        System.out.println("STEP 13: Password field is filled.");

        WebElement confirmPasswordElement = driver.findElement(By.id("repeatedPassword"));
        String confirmPasswordValue = "Parola123!";
        confirmPasswordElement.sendKeys(confirmPasswordValue);
        System.out.println("STEP 14: Confirm Password field is filled.");

        WebElement registerButtonElement = driver.findElement(By.xpath("//input[@value='Register']"));
        registerButtonElement.click();
        System.out.println("STEP 15: Register button is clicked.");

        WebElement openNewAccountLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open New Account")));
        openNewAccountLinkElement.click();
        System.out.println("STEP 16: Open New Account page is opened.");

        WebElement accountTypeDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));
        Select accountTypeSelect = new Select(accountTypeDropdownElement);
        accountTypeSelect.selectByVisibleText("SAVINGS");
        System.out.println("STEP 17: Account type is selected.");

        WebElement fromAccountOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fromAccountId']/option")));
        String fromAccountOptionValue = fromAccountOptionElement.getText();
        System.out.println("STEP 17.1: From Account dropdown is populated: " + fromAccountOptionValue);

        WebElement openNewAccountButtonElement = driver.findElement(By.xpath("//input[@value='Open New Account']"));
        openNewAccountButtonElement.click();
        System.out.println("STEP 18: Open New Account button is clicked.");

        WebElement openAccountResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openAccountResult")));
        System.out.println("STEP 19: Open Account result is captured.");

        WebElement newAccountIdElement = openAccountResultElement.findElement(By.id("newAccountId"));
        String actualNewAccountId = newAccountIdElement.getText();
        System.out.println("STEP 20: New account ID is captured.");

        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");
        System.out.println("STEP 21: Open account is validated.");

        driver.quit();
        System.out.println("STEP 22: The browser is closed.");
    }
}