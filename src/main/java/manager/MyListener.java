package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element by " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator by " + by + " is found successfully");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong!");
        logger.info(throwable.getMessage());
        logger.info(String.valueOf(throwable.fillInStackTrace()));
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String link = "src/test/resources/screenshots-" + i + ".png";
        new HelperBase(driver).takeScreenShot(link);
        logger.info("This link to screenshot with an error: " + link);
    }
}
