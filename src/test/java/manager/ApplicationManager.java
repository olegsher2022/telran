package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigProperties;


import java.io.File;
import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    EventFiringWebDriver driver; // 1. change for get listener
    WebDriver driver;
    UserHelper userHelper;
    CarHelper carHelper;
    static String browser;



    public ApplicationManager(){
        browser = System.getProperty("browser", Browser.CHROME.browserName());
        logger.info(browser);
    }
    public void init() {

        logger.warn(browser);
        logger.warn(Browser.CHROME.browserName());
        logger.warn(Browser.FIREFOX.browserName());
        if (browser.equals(Browser.CHROME.browserName())){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            WebDriver original = new ChromeDriver(options);
            WebDriverListener listener = new WDListener();
            driver = new EventFiringDecorator(listener).decorate(original);
            logger.warn(browser);
        } else if (browser.equals(Browser.FIREFOX.browserName())){
            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--headless");
            WebDriverListener listener = new WDListener();
            WebDriver original = new FirefoxDriver(options);
            driver = new EventFiringDecorator(listener).decorate(original);
            logger.warn(browser);
        }

        driver.navigate().to(ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong((ConfigProperties.getProperty("implicitlyWait")))));



        userHelper = new UserHelper(driver);
        carHelper = new CarHelper(driver);
        logger.info("navigated to the https://ilcarro.web.app/search");
    }

    public UserHelper getUserHelper(){return userHelper;}

    public CarHelper getCarHelper() {return carHelper;}

    public void tearDown() {
        driver.quit();
    }

    public void navigateToMainPage(){
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }

    public boolean isPageUrlHome(){
        String urlCurrent = driver.getCurrentUrl();
        System.out.println(urlCurrent + "--------- url");
        return urlCurrent.equals(ConfigProperties.getProperty("url"));
    }

}
