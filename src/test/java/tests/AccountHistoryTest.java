package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountHistoryTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.manage().deleteAllCookies();
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

        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your account was created successfully')]")));
        String successMessageText = successMessageElement.getText();
        System.out.println("STEP 15.1: Registration success message is displayed: " + successMessageText);

        WebElement accountsOverviewLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts Overview")));
        accountsOverviewLinkElement.click();
        System.out.println("STEP 16: Accounts Overview page is opened.");

        WebElement firstAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='accountTable']//a")));
        System.out.println("STEP 17: Account table is captured.");
        firstAccountLink.click();
        System.out.println("STEP 18: First account link is clicked.");

        WebElement pageTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Details')]")));
        String actualPageTitle = pageTitleElement.getText();
        System.out.println("STEP 19: Account Details title is captured.");

        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
        System.out.println("STEP 20: Account History is validated.");

        driver.quit();
        System.out.println("STEP 21: The browser is closed.");
    }
}