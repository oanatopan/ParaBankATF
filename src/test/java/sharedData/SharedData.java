package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LogUtility;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;
    private String testName;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {

        testName = this.getClass().getSimpleName();
        LogUtility.startTest(testName);

        driver = new ChromeDriver();
        LogUtility.infoLog("The Chrome browser has been opened successfully.");

        driver.manage().window().maximize();
        LogUtility.infoLog("The browser has been maximized.");

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        LogUtility.infoLog("The user navigates to: " + driver.getCurrentUrl());

    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment() {
        if (driver != null) {
            driver.quit();
        }
        LogUtility.finishTest(testName);
    }

    public WebDriver getDriver() {
        return driver;
    }
}