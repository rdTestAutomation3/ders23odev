package driver;

import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyManager;

import java.time.Duration;
import java.util.Objects;

public class DriverFactory {

    public static String browser;
    static PropertyManager propertyManager = new PropertyManager();

    public static void initDriver() {

        // Check if remote driver
        if (Objects.equals(propertyManager.getProperty("BROWSER"), "REMOTE")) {
            initRemoteDriver();
            return;
        }

        // Set settings for selenide browser

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = true;
        //Configuration.timeout = 10000;
        //Configuration.pageLoadTimeout = 30000;
        // Configuration.reportsFolder = "target/test-results/screenshots";
        Configuration.headless = Objects.equals(propertyManager.getProperty("HEADLESS"), "Y");

        browser = Objects.equals(propertyManager.getProperty("BROWSER"), null) ? "chrome" : propertyManager.getProperty("BROWSER");
        //ScreenShooter.captureSuccessfulTests = true;
        switch (browser) {
            case "CHROME":
                Configuration.browser = Browsers.CHROME;
                /*ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--start-incognito");
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                Configuration.browserCapabilities = capabilities;*/
                break;
            case "EDGE":
                Configuration.browser = Browsers.EDGE;
                break;
            case "FIREFOX":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "SAFARI":
                Configuration.browser = Browsers.SAFARI;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
        }

    }

    public static void initRemoteDriver() {
        //  String host="http://localhost:4444/wd/hub";
        //String host = propertyManager.getProperty("SELENIUM_HUB_URL");

        String browserName = "CHROME";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("screenResolution","1920x1080");
        // capabilities.setBrowserName("chrome");
        //  capabilities.setCapability("selenoid:options", ImmutableMap.of(
        //      "enableVNC", true,
        //      "enableVideo", true
        //  ));


        /*Configuration.browser = browserName;
        Configuration.headless = Objects.equals(propertyManager.getProperty("HEADLESS"), "Y");
        Configuration.remote = host;
        Configuration.browserCapabilities = capabilities;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.proxyEnabled = false;*/

    }

    //derste hoca bir try-catch eklemiş?

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }


    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }


    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }
    public static void clearCookies(){
        open(propertyManager.getProperty("APP_URL"));
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    // public static void close(){
    //currentDriver().quit();
    //  }
}