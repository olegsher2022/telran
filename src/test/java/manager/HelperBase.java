package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver driver) {
        this.wd = driver;
    }

    private WebElement findElementBase(By locator){
        return wd.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        return wd.findElements(locator);
    }


    public void clickBase(By locator){
        findElementBase(locator).click();

    }

    public String getTextBase(By locator){
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text){
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult){
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)){
            return true;
        } else{
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }
}