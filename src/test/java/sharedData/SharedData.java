package sharedData;

import modelObject.RegisterModel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.RegisterPage;
import utils.AllureAppender;
import utils.LogUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class SharedData {

    private WebDriver driver;
    private String testName;
    public static String sharedUsername;
    public static String sharedPassword;

    @BeforeSuite(alwaysRun = true)
    public void registerOnce() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver tempDriver = new ChromeDriver(options);
        try {
            RegisterModel testData = new RegisterModel("RegisterData.json");
            sharedUsername = "oana" + System.currentTimeMillis();
            sharedPassword = testData.getPassword();
            RegisterPage registerPage = new RegisterPage(tempDriver);
            tempDriver.get("https://parabank.parasoft.com/parabank/register.htm");
            registerPage.registerProcess(sharedUsername, testData);
            LogUtility.infoLog("BeforeSuite: shared user registered: " + sharedUsername);
        } finally {
            tempDriver.quit();
        }
    }

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
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        LogUtility.infoLog("The user navigates to: " + driver.getCurrentUrl());

        if (!testName.equals("RegisterTest") && !testName.equals("LoginInvalidTest")) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginValidProcess(sharedUsername, sharedPassword);
            LogUtility.infoLog("BeforeMethod: logged in as: " + sharedUsername);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            saveScreenshot();
            takeDebugSnapshot("FAILED_" + testName);
        }
        if (driver != null) {
            driver.quit();
        }
        LogUtility.finishTest(testName);
    }

    public void saveScreenshot() {
        AllureAppender.attachScreenshot(driver);
    }

    private void takeDebugSnapshot(String label) {
        try {
            Files.createDirectories(Paths.get("target/screenshots"));
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("target/screenshots/" + label + ".png"));
            Files.writeString(Paths.get("target/screenshots/" + label + ".html"), driver.getPageSource());
            LogUtility.infoLog("Debug snapshot saved: target/screenshots/" + label);
        } catch (IOException e) {
            LogUtility.errorLog("Could not save debug snapshot: " + e.getMessage());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}