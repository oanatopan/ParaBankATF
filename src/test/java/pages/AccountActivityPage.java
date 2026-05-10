package pages;

import modelObject.FindTransactionsModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogUtility;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "month")
    private WebElement monthSelectElement;

    @FindBy(id = "transactionType")
    private WebElement typeSelectElement;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement goButtonElement;

    @FindBy(xpath = "//h1[text()='Account Activity']")
    private WebElement activityTitleElement;

    @FindBy(id = "rightPanel")
    private WebElement rightPanelElement;

    public void filterProcess(FindTransactionsModel testData) {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(monthSelectElement));

        selectMethods.selectByVisibleText(monthSelectElement, testData.getActivityPeriod());
        LogUtility.infoLog("The user selects " + testData.getActivityPeriod() + " from the activity period dropdown");

        selectMethods.selectByVisibleText(typeSelectElement, testData.getTransactionType());
        LogUtility.infoLog("The user selects " + testData.getTransactionType() + " from the transaction type dropdown");

        elementsMethods.clickElement(goButtonElement);
        LogUtility.infoLog("The user clicks on the Go button");
    }

    public String getActivityTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(activityTitleElement));
        String activityTitle = elementsMethods.getElementText(activityTitleElement);
        LogUtility.infoLog("The user sees the Account Activity page with title: " + activityTitle);
        return activityTitle;
    }

    public boolean isRightPanelDisplayed() {
        return rightPanelElement.isDisplayed();
    }
}