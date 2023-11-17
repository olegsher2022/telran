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

public class SeleniumXpathPhoneBook {
    WebDriver wd;

    @BeforeClass
    public void preconditions() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void textOnHomePage() {
        WebElement h1 = wd.findElement(By.xpath("//*[@id='root']/div[2]//h1"));
        Assert.assertEquals(h1.getText(), "Home Component");
        WebElement h2 = wd.findElement(By.xpath("//*[@id='root']/div[2]//h2"));
        Assert.assertTrue(h2.getText().contains("React Contacts App"));
        WebElement h3 = wd.findElement(By.xpath("//*[@id='root']/div[2]//h3"));
        Assert.assertTrue(h3.getText().contains("For QA Testing"));
        System.out.println(h1.getText() + " " + h2.getText() + " " + h3.getText());
    }
    @Test
    public void phonebookLogo() {

        WebElement phonebookLogo = wd.findElement(By.xpath("//*[@id='root']/div[1]//h1"));
        Assert.assertTrue(phonebookLogo.getText().contains("PHONEBOOK"));
        System.out.println(phonebookLogo.getText());


    }
    @Test
    public void homeTab() {
        WebElement homeTab = wd.findElement(By.xpath("//a[@href='/home']"));
       Assert.assertTrue(homeTab.getText().contains("HOME"));
        System.out.println(homeTab.getText());

    }
    @Test
    public void aboutTab() {
        WebElement aboutTab = wd.findElement(By.xpath("//a[@href='/about']"));
        Assert.assertTrue(aboutTab.getText().contains("ABOUT"));
        System.out.println(aboutTab.getText());

    }
    @Test
    public void loginTab() {
        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        Assert.assertTrue(loginTab.getText().contains("LOGIN"));
        System.out.println(loginTab.getText());

    }
    @AfterClass
    public void tearDown() {
         wd.quit();
    }

}
