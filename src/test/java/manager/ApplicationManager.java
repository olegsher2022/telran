package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.WeakHashMap;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver driver;

    UserHelper userHelper;

    public void init() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.register(new WDListener());


        userHelper = new UserHelper(driver);
        logger.info("navigated to the https://ilcarro.web.app/searc");
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void tearDown() {
        driver.quit();
    }

}
