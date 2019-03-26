package pages;

import browser.Browser;
import org.openqa.selenium.support.PageFactory;
import browser.BrowserProvider;

public abstract class AbstractedPage {

    protected Browser browser;

    public AbstractedPage() {
        this.browser = BrowserProvider.getBrowser();
        PageFactory.initElements(browser, this);
    }
}
