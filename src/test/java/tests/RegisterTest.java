package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        String actualSuccessMessage = registerPage.getSuccessMessage();
        System.out.println("STEP 5: The Register success message is captured.");

        Assert.assertTrue(actualSuccessMessage.contains("Your account was created successfully. You are now logged in."),
                "Register success message is not correct.");
        System.out.println("STEP 6: The Register success message is validated.");

        driver.quit();
        System.out.println("STEP 7: The browser is closed.");
    }
}