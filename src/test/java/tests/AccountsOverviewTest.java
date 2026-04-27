package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("STEP 16: Checking if registration failed.");

        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[contains(@class,'error')]"));

        if (!errorMessage.isEmpty()) {
            System.out.println("STEP 17: Registration failed.");
            System.out.println("ERROR TEXT: " + errorMessage.get(0).getText());
            Assert.fail("ERROR: Registration failed: " + errorMessage.get(0).getText());
        }

        WebElement accountsOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts Overview")));
        accountsOverviewLink.click();
        System.out.println("STEP 18: Accounts Overview link is clicked.");
        System.out.println("STEP 19: Accounts Overview page is opened.");

        WebElement accountTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountTable")));
        String accountTableText = accountTable.getText();
        System.out.println("STEP 20: Account table is captured.");

        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
        System.out.println("STEP 21: Account table is validated.");

        driver.quit();
        System.out.println("STEP 22: The browser is closed.");
    }
}
