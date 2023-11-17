package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositive() {

/*
1. click login
2. fill input email
3. fill input password
4. click yalla button
5. validate by text: Logged in success   in the element //h2[@class='message']
 */

        WebElement btnLogin = driver.findElement(By.xpath(" //a[.=' Log in ']"));
        btnLogin.click();

        WebElement inputEmail = driver.findElement(By.xpath(" //input[@id='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("nefr42@gmail.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Rita12345$");

        WebElement btnYalla = driver.findElement(By.xpath(" //button[.='Y’alla!']"));
        btnYalla.click();
        System.out.println(btnYalla.getText());


        Assert.assertTrue(driver.findElements(By.xpath("//h1[.='Logged in']")).size() > 0);

        WebElement buttonOK = driver.findElement(By.xpath("//button[@class='positive-button ng-star-inserted']"));
        buttonOK.click();
//
//        WebElement textMessagePopUpH2 = driver.findElement(By.xpath("//h2[@class='message']"));
//        String textMessageH2 = textMessagePopUpH2.getText().trim().toUpperCase();
//        String expectedResult = "Logged in success".toUpperCase();
//
//        Assert.assertEquals(textMessageH2, expectedResult);
//
        Assert.assertTrue(driver.findElements(By.xpath("//a[@class='navigation-link ng-star-inserted']")).size() > 0);
        WebElement logout = driver.findElement(By.xpath("//a[@class='navigation-link ng-star-inserted']"));
        logout.click();


    }
//*[@class='message']

    @AfterClass
    public void postConditions() {
        driver.quit();
    }

}