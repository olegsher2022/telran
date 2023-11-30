package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver driver; // 1. change for get listener

    UserHelper userHelper;

    public void init() {
        driver = new EventFiringWebDriver(new ChromeDriver()); // 2. change for get listener
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.register(new WDListener()); // 3.  change for get listener


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
