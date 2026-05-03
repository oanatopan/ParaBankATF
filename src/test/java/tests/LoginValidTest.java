package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginValidTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        String passwordValue = "Parola123!";
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        loginPage.clickLogOut();
        System.out.println("STEP 5: The Log Out link is clicked.");

        loginPage.loginValidProcess(usernameValue, passwordValue);
        System.out.println("STEP 6: The login form is completed and submitted.");

        String logOutAfterLoginText = loginPage.getLogOutText();
        System.out.println("STEP 7: The Log Out link text is captured.");

        Assert.assertEquals(logOutAfterLoginText, "Log Out", "Login was not successful.");
        System.out.println("STEP 8: The valid login is validated.");

        driver.quit();
        System.out.println("STEP 9: The browser is closed.");
    }
}