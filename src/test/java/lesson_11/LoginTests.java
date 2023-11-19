package lesson_11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
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
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));


        WebElement btnLogin = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
        btnLogin.click();

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("testqa20@gmail.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("123456Aa$");
        WebElement btnYalla = driver.findElement(By.xpath("//button[@type='submit']"));
        btnYalla.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='message']")));
        WebElement textMessagePopUpH2 = driver.findElement(By.xpath("//h2[@class='message']"));
        String textMessageH2 = textMessagePopUpH2.getText().trim().toUpperCase();
        String expectedResult = "Logged in success".toUpperCase();
        Assert.assertEquals(textMessageH2, expectedResult);
    }


    @AfterClass
    public void postConditions() {
        driver.quit();
    }

}