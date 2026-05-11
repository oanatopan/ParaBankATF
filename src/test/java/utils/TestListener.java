package utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import sharedData.SharedData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        if (currentClass instanceof SharedData) {
            ((SharedData) currentClass).saveScreenshot();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            Files.createDirectories(Paths.get("target/allure-results"));
            InputStream is = getClass().getClassLoader()
                    .getResourceAsStream("environment.properties");
            if (is != null) {
                Files.copy(is, Paths.get("target/allure-results/environment.properties"),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println("Could not copy environment.properties: " + e.getMessage());
        }
    }

}