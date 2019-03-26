package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import property.PropertyProvider;

public class GmailPasswordPage extends AbstractedPage {

    @FindBy(xpath = "//div[@class='Xb9hP']/input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement nextButton;

    public GmailPasswordPage fillGmailPasswordInput() {
        browser.waitForElementVisible(By.xpath("//div[@class='Xb9hP']/input[@type='password']"));
        passwordInput.sendKeys(PropertyProvider.getProperty("password"));
        return new GmailPasswordPage();
    }

    public GmailMainPage pressPasswordNextButton() {
        browser.waitForElementAndClick(nextButton);
        return new GmailMainPage();
    }

    public boolean isPasswordInputDisplayed() {
        browser.waitForElementVisible(passwordInput);
        return passwordInput.isDisplayed();
    }
}
