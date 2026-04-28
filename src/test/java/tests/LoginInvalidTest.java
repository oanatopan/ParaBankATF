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
        System.out.println("STEP 3: Login page is opened.");

        elementsMethods = new ElementsMethods(driver);

        WebElement loginUsernameElement = driver.findElement(By.name("username"));
        elementsMethods.fillElement(loginUsernameElement, "utilizator_inexistent");
        System.out.println("STEP 4: Username field is filled.");

        WebElement loginPasswordElement = driver.findElement(By.name("password"));
        elementsMethods.fillElement(loginPasswordElement, "parola123");
        System.out.println("STEP 5: Password field is filled.");

        WebElement loginButtonElement = driver.findElement(By.xpath("//input[@value='Log In']"));
        elementsMethods.clickJS(loginButtonElement);
        System.out.println("STEP 6: Log In button is clicked.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement errorTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
        String actualErrorTitle = elementsMethods.getElementText(errorTitleElement);
        System.out.println("STEP 7: Error title is captured.");

        Assert.assertFalse(actualErrorTitle.isEmpty(), "Error page was not displayed.");
        System.out.println("STEP 8: Invalid login is validated.");

        driver.quit();
        System.out.println("STEP 9: The browser is closed.");
    }
}