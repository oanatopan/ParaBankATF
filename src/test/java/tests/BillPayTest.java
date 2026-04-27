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

public class BillPayTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

        WebElement billPayLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bill Pay")));
        billPayLinkElement.click();
        System.out.println("STEP 16: Bill Pay page is opened.");

        WebElement payeeNameElement = driver.findElement(By.name("payee.name"));
        String payeeNameValue = "Electrica SA";
        payeeNameElement.sendKeys(payeeNameValue);
        System.out.println("STEP 17: Payee Name field is filled.");

        WebElement payeeStreetElement = driver.findElement(By.name("payee.address.street"));
        String payeeStreetValue = "Str. Energiei 10";
        payeeStreetElement.sendKeys(payeeStreetValue);
        System.out.println("STEP 18: Payee Street field is filled.");

        WebElement payeeCityElement = driver.findElement(By.name("payee.address.city"));
        String payeeCityValue = "Baia Mare";
        payeeCityElement.sendKeys(payeeCityValue);
        System.out.println("STEP 19: Payee City field is filled.");

        WebElement payeeStateElement = driver.findElement(By.name("payee.address.state"));
        String payeeStateValue = "Maramures";
        payeeStateElement.sendKeys(payeeStateValue);
        System.out.println("STEP 20: Payee State field is filled.");

        WebElement payeeZipElement = driver.findElement(By.name("payee.address.zipCode"));
        String payeeZipValue = "430001";
        payeeZipElement.sendKeys(payeeZipValue);
        System.out.println("STEP 21: Payee Zip Code field is filled.");

        WebElement payeePhoneElement = driver.findElement(By.name("payee.phoneNumber"));
        String payeePhoneValue = "0744111222";
        payeePhoneElement.sendKeys(payeePhoneValue);
        System.out.println("STEP 22: Payee Phone field is filled.");

        WebElement accountNumberElement = driver.findElement(By.name("payee.accountNumber"));
        String accountNumberValue = "12345";
        accountNumberElement.sendKeys(accountNumberValue);
        System.out.println("STEP 23: Account Number field is filled.");

        WebElement verifyAccountElement = driver.findElement(By.name("verifyAccount"));
        String verifyAccountValue = "12345";
        verifyAccountElement.sendKeys(verifyAccountValue);
        System.out.println("STEP 24: Verify Account field is filled.");

        WebElement amountElement = driver.findElement(By.name("amount"));
        String amountValue = "50";
        amountElement.sendKeys(amountValue);
        System.out.println("STEP 25: Amount field is filled.");

        WebElement fromAccountDropdownElement = driver.findElement(By.name("fromAccountId"));
        Select fromAccountSelect = new Select(fromAccountDropdownElement);
        fromAccountSelect.selectByIndex(0);
        System.out.println("STEP 26: From account is selected.");

        WebElement sendPaymentButtonElement = driver.findElement(By.xpath("//input[@value='Send Payment']"));
        sendPaymentButtonElement.click();
        System.out.println("STEP 27: Send Payment button is clicked.");

        WebElement billPayResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billpayResult")));
        String actualBillPayResult = billPayResultElement.getText();
        System.out.println("STEP 28: Bill Pay result is captured.");
        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"), "The payment was not completed.");
        System.out.println("STEP 29: Bill Pay is validated.");

        driver.quit();
        System.out.println("STEP 30: The browser is closed.");
    }
}
