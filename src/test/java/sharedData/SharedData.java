package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.AllureAppender;
import utils.LogUtility;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;
    private String testName;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LogUtility.startTest(testName);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        LogUtility.infoLog("The Chrome browser has been opened successfully.");

        driver.manage().window().maximize();
        LogUtility.infoLog("The browser has been maximized.");

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        LogUtility.infoLog("The user navigates to: " + driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            saveScreenshot();
        }

        if (driver != null) {
            driver.quit();
        }

        LogUtility.finishTest(testName);
    }

    public void saveScreenshot() {
        AllureAppender.attachScreenshot(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
}