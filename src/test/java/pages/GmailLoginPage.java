package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import property.PropertyProvider;

import java.util.List;

public class GmailLoginPage extends AbstractedPage {

    private static final String TAB_NAME = "Gmail";

    @FindBy(xpath = "//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    @FindBy(css = "input#identifierId.whsOnd.zHQkBf")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    private By signInButtonLocator = By.xpath("//*[contains(text(), 'Create an account')]/preceding::*[contains(text(), 'Sign in')]");

    public GmailLoginPage pressSignInButton() {
        List<WebElement> elements = browser.findElements(signInButtonLocator);
        for (WebElement elem : elements) {
            if (elem.isDisplayed()) {
                elem.click();
                break;
            }
        }
        return this;
    }

    public GmailLoginPage fillEmailIInput() {
        browser.switchToRequiredTabInBrowser(TAB_NAME);
        browser.waitForElementVisible(emailInput);
        emailInput.sendKeys(PropertyProvider.getProperty("login"));
        return this;
    }

    public GmailPasswordPage pressNextButton() {
        browser.waitForElementVisible(By.id("identifierNext"));
        nextButton.click();
        return new GmailPasswordPage();
    }
}