package manager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class WDListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);

    public WDListener() {
        super();
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        super.afterAlertAccept(driver);
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        super.afterAlertDismiss(driver);
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        super.beforeAlertDismiss(driver);
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        super.afterNavigateBack(driver);
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        super.beforeNavigateForward(driver);
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        super.afterNavigateForward(driver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        super.afterNavigateRefresh(driver);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        super.afterScript(script, driver);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
    }
}
