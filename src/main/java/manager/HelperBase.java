package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = driver.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return (driver.findElements(locator).size() > 0);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenShot(String link) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);//src/test/resources/screenshots
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void returnToHome(){
        driver.navigate().to("https://la-vocal.melodic-mind.com/");
    }

}

