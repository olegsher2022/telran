package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WDListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);
    public WDListener() { super();
    }

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyCall(target, method, args);
    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyCall(target, method, args, result);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
    }

    @Override
    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyWebDriverCall(driver, method, args);
    }

    @Override
    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyWebDriverCall(driver, method, args, result);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        takeScreenshot((TakesScreenshot) driver);
    }

    @Override
    public void beforeGetCurrentUrl(WebDriver driver) {
        WebDriverListener.super.beforeGetCurrentUrl(driver);
    }

    @Override
    public void afterGetCurrentUrl(String result, WebDriver driver) {
        WebDriverListener.super.afterGetCurrentUrl(result, driver);
    }

    @Override
    public void beforeGetTitle(WebDriver driver) {
        WebDriverListener.super.beforeGetTitle(driver);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        WebDriverListener.super.afterGetTitle(driver, result);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);

    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("WDListener: afterFindElement - " + locator + result);
//        takeScreenshot((TakesScreenshot) driver);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
    }

    @Override
    public void beforeGetPageSource(WebDriver driver) {
        WebDriverListener.super.beforeGetPageSource(driver);
    }

    @Override
    public void afterGetPageSource(WebDriver driver, String result) {
        WebDriverListener.super.afterGetPageSource(driver, result);
    }

    @Override
    public void beforeClose(WebDriver driver) {
        WebDriverListener.super.beforeClose(driver);
    }

    @Override
    public void afterClose(WebDriver driver) {
        WebDriverListener.super.afterClose(driver);
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        WebDriverListener.super.beforeQuit(driver);
    }

    @Override
    public void afterQuit(WebDriver driver) {
        WebDriverListener.super.afterQuit(driver);
    }

    @Override
    public void beforeGetWindowHandles(WebDriver driver) {
        WebDriverListener.super.beforeGetWindowHandles(driver);
    }

    @Override
    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
        WebDriverListener.super.afterGetWindowHandles(driver, result);
    }

    @Override
    public void beforeGetWindowHandle(WebDriver driver) {
        WebDriverListener.super.beforeGetWindowHandle(driver);
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        WebDriverListener.super.afterGetWindowHandle(driver, result);
    }

    @Override
    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        WebDriverListener.super.beforeExecuteScript(driver, script, args);
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        WebDriverListener.super.afterExecuteScript(driver, script, args, result);
    }

    @Override
    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
        WebDriverListener.super.beforeExecuteAsyncScript(driver, script, args);
    }

    @Override
    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
        WebDriverListener.super.afterExecuteAsyncScript(driver, script, args, result);
    }

    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.beforePerform(driver, actions);
    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.afterPerform(driver, actions);
    }

    @Override
    public void beforeResetInputState(WebDriver driver) {
        WebDriverListener.super.beforeResetInputState(driver);
    }

    @Override
    public void afterResetInputState(WebDriver driver) {
        WebDriverListener.super.afterResetInputState(driver);
    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyWebElementCall(element, method, args);
    }

    @Override
    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyWebElementCall(element, method, args, result);
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
    }

    @Override
    public void beforeSubmit(WebElement element) {
        WebDriverListener.super.beforeSubmit(element);
    }

    @Override
    public void afterSubmit(WebElement element) {
        WebDriverListener.super.afterSubmit(element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
    }

    @Override
    public void beforeClear(WebElement element) {
        WebDriverListener.super.beforeClear(element);
    }

    @Override
    public void afterClear(WebElement element) {
        WebDriverListener.super.afterClear(element);
    }

    @Override
    public void beforeGetTagName(WebElement element) {
        WebDriverListener.super.beforeGetTagName(element);
    }

    @Override
    public void afterGetTagName(WebElement element, String result) {
        WebDriverListener.super.afterGetTagName(element, result);
    }

    @Override
    public void beforeGetAttribute(WebElement element, String name) {
        WebDriverListener.super.beforeGetAttribute(element, name);
    }

    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {
        WebDriverListener.super.afterGetAttribute(element, name, result);
    }

    @Override
    public void beforeIsSelected(WebElement element) {
        WebDriverListener.super.beforeIsSelected(element);
    }

    @Override
    public void afterIsSelected(WebElement element, boolean result) {
        WebDriverListener.super.afterIsSelected(element, result);
    }

    @Override
    public void beforeIsEnabled(WebElement element) {
        WebDriverListener.super.beforeIsEnabled(element);
    }

    @Override
    public void afterIsEnabled(WebElement element, boolean result) {
        WebDriverListener.super.afterIsEnabled(element, result);
    }

    @Override
    public void beforeGetText(WebElement element) {
        WebDriverListener.super.beforeGetText(element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        WebDriverListener.super.afterGetText(element, result);
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElement(element, locator);
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(element, locator, result);
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElements(element, locator);
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(element, locator, result);
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {
        WebDriverListener.super.beforeIsDisplayed(element);
    }

    @Override
    public void afterIsDisplayed(WebElement element, boolean result) {
        WebDriverListener.super.afterIsDisplayed(element, result);
    }

    @Override
    public void beforeGetLocation(WebElement element) {
        WebDriverListener.super.beforeGetLocation(element);
    }

    @Override
    public void afterGetLocation(WebElement element, Point result) {
        WebDriverListener.super.afterGetLocation(element, result);
    }

    @Override
    public void beforeGetSize(WebElement element) {
        WebDriverListener.super.beforeGetSize(element);
    }

    @Override
    public void afterGetSize(WebElement element, Dimension result) {
        WebDriverListener.super.afterGetSize(element, result);
    }

    @Override
    public void beforeGetCssValue(WebElement element, String propertyName) {
        WebDriverListener.super.beforeGetCssValue(element, propertyName);
    }

    @Override
    public void afterGetCssValue(WebElement element, String propertyName, String result) {
        WebDriverListener.super.afterGetCssValue(element, propertyName, result);
    }

    @Override
    public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyNavigationCall(navigation, method, args);
    }

    @Override
    public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyNavigationCall(navigation, method, args, result);
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        WebDriverListener.super.beforeTo(navigation, url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        WebDriverListener.super.afterTo(navigation, url);
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, URL url) {
        WebDriverListener.super.beforeTo(navigation, url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, URL url) {
        WebDriverListener.super.afterTo(navigation, url);
    }

    @Override
    public void beforeBack(WebDriver.Navigation navigation) {
        WebDriverListener.super.beforeBack(navigation);
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        WebDriverListener.super.afterBack(navigation);
    }

    @Override
    public void beforeForward(WebDriver.Navigation navigation) {
        WebDriverListener.super.beforeForward(navigation);
    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        WebDriverListener.super.afterForward(navigation);
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        WebDriverListener.super.beforeRefresh(navigation);
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        WebDriverListener.super.afterRefresh(navigation);
    }

    @Override
    public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyAlertCall(alert, method, args);
    }

    @Override
    public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyAlertCall(alert, method, args, result);
    }

    @Override
    public void beforeAccept(Alert alert) {
        WebDriverListener.super.beforeAccept(alert);
    }

    @Override
    public void afterAccept(Alert alert) {
        WebDriverListener.super.afterAccept(alert);
    }

    @Override
    public void beforeDismiss(Alert alert) {
        WebDriverListener.super.beforeDismiss(alert);
    }

    @Override
    public void afterDismiss(Alert alert) {
        WebDriverListener.super.afterDismiss(alert);
    }

    @Override
    public void beforeGetText(Alert alert) {
        WebDriverListener.super.beforeGetText(alert);
    }

    @Override
    public void afterGetText(Alert alert, String result) {
        WebDriverListener.super.afterGetText(alert, result);
    }

    @Override
    public void beforeSendKeys(Alert alert, String text) {
        WebDriverListener.super.beforeSendKeys(alert, text);
    }

    @Override
    public void afterSendKeys(Alert alert, String text) {
        WebDriverListener.super.afterSendKeys(alert, text);
    }

    @Override
    public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyOptionsCall(options, method, args);
    }

    @Override
    public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyOptionsCall(options, method, args, result);
    }

    @Override
    public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {
        WebDriverListener.super.beforeAddCookie(options, cookie);
    }

    @Override
    public void afterAddCookie(WebDriver.Options options, Cookie cookie) {
        WebDriverListener.super.afterAddCookie(options, cookie);
    }

    @Override
    public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {
        WebDriverListener.super.beforeDeleteCookieNamed(options, name);
    }

    @Override
    public void afterDeleteCookieNamed(WebDriver.Options options, String name) {
        WebDriverListener.super.afterDeleteCookieNamed(options, name);
    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
        WebDriverListener.super.beforeDeleteCookie(options, cookie);
    }

    @Override
    public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {
        WebDriverListener.super.afterDeleteCookie(options, cookie);
    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        WebDriverListener.super.beforeDeleteAllCookies(options);
    }

    @Override
    public void afterDeleteAllCookies(WebDriver.Options options) {
        WebDriverListener.super.afterDeleteAllCookies(options);
    }

    @Override
    public void beforeGetCookies(WebDriver.Options options) {
        WebDriverListener.super.beforeGetCookies(options);
    }

    @Override
    public void afterGetCookies(WebDriver.Options options, Set<Cookie> result) {
        WebDriverListener.super.afterGetCookies(options, result);
    }

    @Override
    public void beforeGetCookieNamed(WebDriver.Options options, String name) {
        WebDriverListener.super.beforeGetCookieNamed(options, name);
    }

    @Override
    public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result) {
        WebDriverListener.super.afterGetCookieNamed(options, name, result);
    }

    @Override
    public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyTimeoutsCall(timeouts, method, args);
    }

    @Override
    public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyTimeoutsCall(timeouts, method, args, result);
    }

    @Override
    public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.beforeImplicitlyWait(timeouts, duration);
    }

    @Override
    public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.afterImplicitlyWait(timeouts, duration);
    }

    @Override
    public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.beforeSetScriptTimeout(timeouts, duration);
    }

    @Override
    public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.afterSetScriptTimeout(timeouts, duration);
    }

    @Override
    public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.beforePageLoadTimeout(timeouts, duration);
    }

    @Override
    public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.afterPageLoadTimeout(timeouts, duration);
    }

    @Override
    public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyWindowCall(window, method, args);
    }

    @Override
    public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result) {
        WebDriverListener.super.afterAnyWindowCall(window, method, args, result);
    }

    @Override
    public void beforeGetSize(WebDriver.Window window) {
        WebDriverListener.super.beforeGetSize(window);
    }

    @Override
    public void afterGetSize(WebDriver.Window window, Dimension result) {
        WebDriverListener.super.afterGetSize(window, result);
    }

    @Override
    public void beforeSetSize(WebDriver.Window window, Dimension size) {
        WebDriverListener.super.beforeSetSize(window, size);
    }

    @Override
    public void afterSetSize(WebDriver.Window window, Dimension size) {
        WebDriverListener.super.afterSetSize(window, size);
    }

    @Override
    public void beforeGetPosition(WebDriver.Window window) {
        WebDriverListener.super.beforeGetPosition(window);
    }

    @Override
    public void afterGetPosition(WebDriver.Window window, Point result) {
        WebDriverListener.super.afterGetPosition(window, result);
    }

    @Override
    public void beforeSetPosition(WebDriver.Window window, Point position) {
        WebDriverListener.super.beforeSetPosition(window, position);
    }

    @Override
    public void afterSetPosition(WebDriver.Window window, Point position) {
        WebDriverListener.super.afterSetPosition(window, position);
    }

    @Override
    public void beforeMaximize(WebDriver.Window window) {
        WebDriverListener.super.beforeMaximize(window);
    }

    @Override
    public void afterMaximize(WebDriver.Window window) {
        WebDriverListener.super.afterMaximize(window);
    }

    @Override
    public void beforeFullscreen(WebDriver.Window window) {
        WebDriverListener.super.beforeFullscreen(window);
    }

    @Override
    public void afterFullscreen(WebDriver.Window window) {
        WebDriverListener.super.afterFullscreen(window);
    }

    private void takeScreenshot(TakesScreenshot takesScreenshot) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = "src/test/screenshots/screenshot-" + timestamp + ".png";
        logger.info("Create screenshot: " + fileName);
        try {
            File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File screenshot = new File(fileName);
            Files.copy(tmp,screenshot);

        } catch (IOException e){
            logger.error("Screenshot fail:" + e.getMessage());
            e.printStackTrace();

        }
    }
}
