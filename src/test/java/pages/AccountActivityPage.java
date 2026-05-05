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
    public WebElement monthSelectElement;

    @FindBy(id = "transactionType")
    public WebElement typeSelectElement;

    @FindBy(xpath = "//input[@value='Go']")
    public WebElement goButtonElement;

    @FindBy(xpath = "//h1[text()='Account Activity']")
    public WebElement activityTitleElement;

    @FindBy(id = "rightPanel")
    public WebElement rightPanelElement;

    public void filterProcess(FindTransactionsModel testData) {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(monthSelectElement));

        selectMethods.selectByVisibleText(monthSelectElement, testData.getActivityPeriod());
        LogUtility.infoLog("The user selects " + testData.getActivityPeriod() + " from activity period dropdown");

        selectMethods.selectByVisibleText(typeSelectElement, testData.getTransactionType());
        LogUtility.infoLog("The user selects " + testData.getTransactionType() + " from transaction type dropdown");

        elementsMethods.clickElement(goButtonElement);
        LogUtility.infoLog("The user clicks on Go button");
    }

    public String getActivityTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(activityTitleElement));
        return elementsMethods.getElementText(activityTitleElement);
    }

    public boolean isRightPanelDisplayed() {
        return rightPanelElement.isDisplayed();
    }
}