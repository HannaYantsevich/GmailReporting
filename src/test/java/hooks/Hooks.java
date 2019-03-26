package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import browser.BrowserProvider;
import property.PropertyProvider;
import reporting.MyLogger;

public class Hooks {

    @Before
    public void beforeScenario(){
        BrowserProvider.getBrowser().get(PropertyProvider.getProperty("url"));
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = BrowserProvider.getBrowser().getScreenshotAsBytes();
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                MyLogger.error("Unable to attach screenshot ", e);
            }
        }
        BrowserProvider.closeBrowser();
    }
}
