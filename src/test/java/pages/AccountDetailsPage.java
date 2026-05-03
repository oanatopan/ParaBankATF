package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage{


    public AccountDetailsPage(WebDriver driver) {
        super(driver);

}

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    public WebElement pageTitleElement;

    public String getPageTitle() {
        elementsMethods.wait.until(ExpectedConditions.visibilityOf(pageTitleElement));
        return elementsMethods.getElementText(pageTitleElement);
    }
}