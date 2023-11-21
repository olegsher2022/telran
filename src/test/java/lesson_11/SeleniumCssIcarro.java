package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumCssIcarro {

    WebDriver driver;

    @BeforeClass
    public void precondition() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        driver.close();
        driver.quit();
    }


    @Test(priority = 1)
    public void cssSelectorH2() {
        WebElement h2TextElement = driver.findElement(By.cssSelector("h2")); // h2 - it is tag name
        Assert.assertEquals(h2TextElement.getText(), "Type your data and hit Yalla!");
    }

    @Test(priority = 2)
    public void tagNameH2() {
        WebElement h2ByTagName = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(h2ByTagName.getText(), "Type your data and hit Yalla!");
    }

    @Test
    public void cssSelectorSubtitle() {
        WebElement subtitleTextElementBycssSelector = driver.findElement(By.cssSelector(".subtitle"));//by class value
        Assert.assertEquals(subtitleTextElementBycssSelector.getText(), "Type your data and hit Yalla!");
    }

    @Test
    public void cssClassNameSubtitle() {
        WebElement h2TextElementByClassName = driver.findElement(By.className("subtitle"));//by class value
        Assert.assertEquals(h2TextElementByClassName.getText(), "Type your data and hit Yalla!");
    }

    @Test
    public void subtitleByCssSelector() {

        //       By.cssSelector("h2.subtitle")

        WebElement h2TextElementByClass = driver.findElement(By.cssSelector(".subtitle"));//by class value
        Assert.assertEquals(h2TextElementByClass.getText(), "Type your data and hit Yalla!");
        System.out.println(h2TextElementByClass.getText());
    }
    @Test
    public void subtitleByCssSelector2() {

        WebElement h2TextElementByClassName = driver.findElement(By.className("subtitle"));//by class value
        Assert.assertEquals(h2TextElementByClassName.getText(), "Type your data and hit Yalla!");
        System.out.println(h2TextElementByClassName.getText());
    }
    @Test
    public void subtitleByCssSelector3() {
        WebElement h2ByClassAndTagTogether =
                driver.findElement(By.cssSelector("h2.subtitle"));
        Assert.assertEquals( h2ByClassAndTagTogether .getText(), "Type your data and hit Yalla!");
    }

    @Test
    public void cityByCssSelector() {

        WebElement inputCityById = driver.findElement(By.cssSelector("#city")); //by id value
        Assert.assertTrue(inputCityById.getAttribute("type").equals("text"));
    }

    @Test
    public void cityByCssSelectorById() {


        WebElement inputCityByIdDirectly = driver.findElement(By.id("city")); //by id value
        Assert.assertEquals(inputCityByIdDirectly.getAttribute("type"), "text");
        System.out.println(inputCityByIdDirectly.getAttribute("type"));
    }
//    @Test
//    public void cityByCssSelectorByLinkText() {
//
//
//        WebElement h2ByText = driver.findElement(By.linkText(" Log in"));
//        Assert.assertEquals(h2ByText.getText(), "Y’alla!");
//        WebElement h2ByTextPart = driver.findElement(By.partialLinkText("Ya"));
//        Assert.assertEquals(h2ByTextPart.getText(), "Y’alla!");//  }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        // xpath
//
//        WebElement xpathLabel = driver.findElement(By.xpath("//label[@for='city']"));
//        // //label[@for='city']/.. jump to 1 tag up
//        // //label[@for='city']/span
//        System.out.println(xpathLabel.getText());
//
//        // Фильтр по месту среди соседей 13 page


}
