package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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


import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    EventFiringWebDriver driver; // 1. change for get listener
    WebDriver driver;
    UserHelper userHelper;
    static String browser;



    public ApplicationManager(){
        browser = System.getProperty("browser", Browser.CHROME.browserName());
        logger.info(browser);
    }
    public void init() {
//        browser = System.getProperty("browser");
//        browser = "firefox";
        logger.warn(browser);
        logger.warn(Browser.CHROME.browserName());
        logger.warn(Browser.FIREFOX.browserName());
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        WebDriver original = new ChromeDriver(options);
//        WebDriverListener listener = new WDListener();
//        driver = new EventFiringDecorator(listener).decorate(original);
        if (browser.equals(Browser.CHROME.browserName())){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            WebDriver original = new ChromeDriver(options);
            WebDriverListener listener = new WDListener();
            driver = new EventFiringDecorator(listener).decorate(original);
            logger.warn(browser);
        } else if (browser.equals(Browser.FIREFOX.browserName())){
//            WebDriver original = new FirefoxDriver();
//            WebDriverListener listener = new WDListener();
//            driver = new EventFiringDecorator(listener).decorate(original);
             FirefoxOptions options = new FirefoxOptions();
//            options.setBinary(getFirefoxLocation());
//            options.addArguments("-headless");
            FirefoxProfile profile = new FirefoxProfile();
            options.setProfile(profile);
            driver = new FirefoxDriver(options) ;
            logger.warn(browser);
        }
//           driver.get("http://example.com/");
//           WebElement header = decorated.findElement(By.tagName("h1"));
//           String headerText = header.getText();



//        driver = new EventFiringWebDriver(new ChromeDriver()); // 2. change for get listener
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        driver = new EventFiringWebDriver(new ChromeDriver(options)); // 2. change for get listener


//        driver.navigate().to("https://ilcarro.web.app/search");
        driver.navigate().to(ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.register(new WDListener()); // 3.  change for get listener


        userHelper = new UserHelper(driver);
        logger.info("navigated to the https://ilcarro.web.app/searc");
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

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
