package pages;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountActivityPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public SelectMethods selectMethods;

    public AccountActivityPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        selectMethods = new SelectMethods(this.driver);
        PageFactory.initElements(this.driver, this);
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

    public void filterProcess() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(monthSelectElement));

        selectMethods.selectByVisibleText(monthSelectElement, "All");
        System.out.println("The user sets the Activity Period filter to All.");

        selectMethods.selectByVisibleText(typeSelectElement, "All");
        System.out.println("The user sets the Transaction Type filter to All.");

        elementsMethods.clickElement(goButtonElement);
        System.out.println("The user clicks the Go button.");
    }

    public String getActivityTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(activityTitleElement));
        return elementsMethods.getElementText(activityTitleElement);
    }

    public boolean isRightPanelDisplayed() {
        return rightPanelElement.isDisplayed();
    }
}