package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPage extends BasePage {

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    private WebElement pageTitleElement;

    public String getPageTitle() {
        elementsMethods.waitVisibleElement(pageTitleElement);
        String pageTitle = elementsMethods.getElementText(pageTitleElement);
        logStep("The user sees the Account Details page with title: " + pageTitle);
        return pageTitle;
    }
}