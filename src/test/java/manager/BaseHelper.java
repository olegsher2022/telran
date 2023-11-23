package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }


    public void clickBase(By locator) {
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator) {
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text) {
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }

    public void jsClickBase(String locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(locator);
    }

    public void clickByXY(By locator, int down, int right) {  // 10  12
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX() + rect.getWidth() / 8;
        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }

    public boolean isElementExist(By locator) {
        return findElementsBase(locator).size() > 0;
    }
}