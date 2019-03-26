package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import property.PropertyProvider;
import reporting.MyLogger;

import java.util.concurrent.TimeUnit;

public class BrowserProvider {

    private static Browser browser;
    private static WebDriver driver;

    private static Browser createBrowserInstance() {
        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));
        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                browser = new Browser(driver);
                MyLogger.info("chrome driver created");
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                browser = new Browser(driver);
                MyLogger.info("firefox driver created");
                break;
            case OPERA:
                driver = createOperaDriver();
                browser = new Browser(driver);
                MyLogger.info("opera driver created");
                break;
            case EDGE:
                driver = createEdgeDriver();
                browser = new Browser(driver);
                MyLogger.info("edge driver created");
                break;
            default:
                driver = createChromeDriver();
                browser = new Browser(driver);
                MyLogger.info("chrome driver created");
        }
        browser.manage().deleteAllCookies();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return browser;
    }

    public static Browser getBrowser() {
        if (browser == null) {
            createBrowserInstance();
        }
        return browser;
    }

    public static void closeBrowser() {
        try {
            if (browser != null) {
                browser.quit();
            }
        } catch (WebDriverException e) {
            MyLogger.error("Unable to close driver instance " + e);
        } finally {
            browser = null;
        }
    }

    private static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

}