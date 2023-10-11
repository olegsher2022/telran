import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Web Automation")
@Feature("Login Feature")
public class SeleniumTest {

    WebDriver driver;
//    private final ChromeOptions options = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {
//        options.addArguments("--headless");
        // Set up your WebDriver instance (in this case, ChromeDriver)
//        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new FirefoxDriver();
//        driver.get("http://google.com");
    }

    @Test(description = "Test login functionality")
    @Story("Valid login")
    public void testLogin() {
        // Navigate to the login page
        driver.get("http://172.17.0.3/");

        // Perform login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("yourUsername");
        passwordField.sendKeys("yourPassword");
        loginButton.click();

        // Add assertions or verifications here

        // For Allure reporting, you can add steps:
        Allure.step("Logged in successfully", Status.PASSED);
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
