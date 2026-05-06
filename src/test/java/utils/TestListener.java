package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import sharedData.SharedData;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        if (currentClass instanceof SharedData) {
            ((SharedData) currentClass).saveScreenshot();
        }
    }
}