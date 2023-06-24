package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver driver;
    EventFiringWebDriver driver;
    HelperUser user;
    Properties properties;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        String configuration = System.getProperty("configuration", "config");
        logger.info("Config file is: " + configuration);
        String fileName = format("src/test/resources/congigLaVocal.properties");
        properties.load(new FileReader(new File("src/test/resources/congigLaVocal.properties")));
        // properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", configuration))));
        logger.info("Config file fullname is :"+ fileName);
        properties.load((new FileReader(new File(fileName))));

        if(browser.equals(BrowserType.CHROME)){
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Testing on Chrome Driver");
        }else if (browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Testing in Firefox");

        }

        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().window().maximize();
        driver.navigate().to("https://la-vocal.melodic-mind.com/");
        //driver.navigate().to(properties.getProperty("web.baseURL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new HelperUser(driver);
    }

    public HelperUser getUser() {
        return user;
    }

    public String getEmail(){
        return properties.getProperty("web.email");
    }
    public String getPassword(){
        return properties.getProperty("web.password");
    }

    public void stop() {
//        wd.quit();
    }

}
