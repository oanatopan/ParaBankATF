package tests;

import helpMethods.ElementsMethods;
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
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.manage().deleteAllCookies();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);

        WebElement firstNameElement = driver.findElement(By.id("customer.firstName"));
        elementsMethods.fillElement(firstNameElement, "Oana");
        System.out.println("STEP 4: First Name field is filled.");

        WebElement lastNameElement = driver.findElement(By.id("customer.lastName"));
        elementsMethods.fillElement(lastNameElement, "Topan");
        System.out.println("STEP 5: Last Name field is filled.");

        WebElement streetElement = driver.findElement(By.id("customer.address.street"));
        elementsMethods.fillElement(streetElement, "Republicii");
        System.out.println("STEP 6: Street field is filled.");

        WebElement cityElement = driver.findElement(By.id("customer.address.city"));
        elementsMethods.fillElement(cityElement, "Baia Mare");
        System.out.println("STEP 7: City field is filled.");

        WebElement stateElement = driver.findElement(By.id("customer.address.state"));
        elementsMethods.fillElement(stateElement, "Romania");
        System.out.println("STEP 8: State field is filled.");

        WebElement zipElement = driver.findElement(By.id("customer.address.zipCode"));
        elementsMethods.fillElement(zipElement, "123456");
        System.out.println("STEP 9: Zip Code field is filled.");

        WebElement phoneElement = driver.findElement(By.id("customer.phoneNumber"));
        elementsMethods.fillElement(phoneElement, "0722000000");
        System.out.println("STEP 10: Phone field is filled.");

        WebElement ssnElement = driver.findElement(By.id("customer.ssn"));
        elementsMethods.fillElement(ssnElement, "123-45-678");
        System.out.println("STEP 11: SSN field is filled.");

        WebElement usernameElement = driver.findElement(By.id("customer.username"));
        String usernameValue = "oana" + System.currentTimeMillis();
        elementsMethods.fillElement(usernameElement, usernameValue);
        System.out.println("STEP 12: Username field is filled.");

        WebElement passwordElement = driver.findElement(By.id("customer.password"));
        elementsMethods.fillElement(passwordElement, "Parola123!");
        System.out.println("STEP 13: Password field is filled.");

        WebElement confirmPasswordElement = driver.findElement(By.id("repeatedPassword"));
        elementsMethods.fillElement(confirmPasswordElement, "Parola123!");
        System.out.println("STEP 14: Confirm Password field is filled.");

        WebElement registerButtonElement = driver.findElement(By.xpath("//input[@value='Register']"));
        elementsMethods.clickElement(registerButtonElement);
        System.out.println("STEP 15: Register button is clicked.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your account was created successfully')]")));
        String successMessageText = elementsMethods.getElementText(successMessageElement);
        System.out.println("STEP 15.1: Registration success message is displayed: " + successMessageText);

        WebElement accountsOverviewLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts Overview")));
        elementsMethods.clickElement(accountsOverviewLinkElement);
        System.out.println("STEP 16: Accounts Overview page is opened.");

        WebElement firstAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='accountTable']//a")));
        System.out.println("STEP 17: Account table is captured.");
        elementsMethods.clickElement(firstAccountLink);
        System.out.println("STEP 18: First account link is clicked.");

        WebElement pageTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Details')]")));
        String actualPageTitle = elementsMethods.getElementText(pageTitleElement);
        System.out.println("STEP 19: Account Details title is captured.");

        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
        System.out.println("STEP 20: Account History is validated.");

        driver.quit();
        System.out.println("STEP 21: The browser is closed.");
    }
}