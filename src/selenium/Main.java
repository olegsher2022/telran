package src.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
	    driver.findElement(By.className("information"));
    }
}


