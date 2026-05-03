package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginInvalidTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println("STEP 3: The Login page is opened.");

        elementsMethods = new ElementsMethods(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginInvalidProcess();
        System.out.println("STEP 4: The invalid login form is completed and submitted.");

        String actualErrorTitle = loginPage.getErrorTitle();
        System.out.println("STEP 5: The error title is captured.");

        Assert.assertFalse(actualErrorTitle.isEmpty(), "Error page was not displayed.");
        System.out.println("STEP 6: The invalid login error is validated.");

        driver.quit();
        System.out.println("STEP 7: The browser is closed.");
    }
}