package tests;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BillPayTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    SelectMethods selectMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        selectMethods = new SelectMethods(driver);

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
        WebElement billPayLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bill Pay")));
        elementsMethods.clickElement(billPayLinkElement);
        System.out.println("STEP 16: Bill Pay page is opened.");

        WebElement payeeNameElement = driver.findElement(By.name("payee.name"));
        elementsMethods.fillElement(payeeNameElement, "Electrica SA");
        System.out.println("STEP 17: Payee Name field is filled.");

        WebElement payeeStreetElement = driver.findElement(By.name("payee.address.street"));
        elementsMethods.fillElement(payeeStreetElement, "Str. Energiei 10");
        System.out.println("STEP 18: Payee Street field is filled.");

        WebElement payeeCityElement = driver.findElement(By.name("payee.address.city"));
        elementsMethods.fillElement(payeeCityElement, "Baia Mare");
        System.out.println("STEP 19: Payee City field is filled.");

        WebElement payeeStateElement = driver.findElement(By.name("payee.address.state"));
        elementsMethods.fillElement(payeeStateElement, "Maramures");
        System.out.println("STEP 20: Payee State field is filled.");

        WebElement payeeZipElement = driver.findElement(By.name("payee.address.zipCode"));
        elementsMethods.fillElement(payeeZipElement, "430001");
        System.out.println("STEP 21: Payee Zip Code field is filled.");

        WebElement payeePhoneElement = driver.findElement(By.name("payee.phoneNumber"));
        elementsMethods.fillElement(payeePhoneElement, "0744111222");
        System.out.println("STEP 22: Payee Phone field is filled.");

        WebElement accountNumberElement = driver.findElement(By.name("payee.accountNumber"));
        elementsMethods.fillElement(accountNumberElement, "12345");
        System.out.println("STEP 23: Account Number field is filled.");

        WebElement verifyAccountElement = driver.findElement(By.name("verifyAccount"));
        elementsMethods.fillElement(verifyAccountElement, "12345");
        System.out.println("STEP 24: Verify Account field is filled.");

        WebElement amountElement = driver.findElement(By.name("amount"));
        elementsMethods.fillElement(amountElement, "50");
        System.out.println("STEP 25: Amount field is filled.");

        WebElement fromAccountDropdownElement = driver.findElement(By.name("fromAccountId"));
        selectMethods.selectByIndex(fromAccountDropdownElement, 0);
        System.out.println("STEP 26: From account is selected.");

        WebElement sendPaymentButtonElement = driver.findElement(By.xpath("//input[@value='Send Payment']"));
        elementsMethods.clickElement(sendPaymentButtonElement);
        System.out.println("STEP 27: Send Payment button is clicked.");

        WebElement billPayResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billpayResult")));
        String actualBillPayResult = elementsMethods.getElementText(billPayResultElement);
        System.out.println("STEP 28: Bill Pay result is captured.");

        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"), "The payment was not completed.");
        System.out.println("STEP 29: Bill Pay is validated.");

        driver.quit();
        System.out.println("STEP 30: The browser is closed.");
    }
}