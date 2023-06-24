package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver driver) {
        super(driver);
    }

     ////////////// sign Up
    public void clickOnContinueWithEmail() {
        click(By.cssSelector("button[class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--rectangle q-btn--rounded bg-white text-white q-btn--actionable q-focusable q-hoverable full-width row text-black'] span[class='col']"));

    }

    public void clickOnSignUpBtn() {
        // click(By.xpath("//button[@class='sign-up cursor-pointer']"));
        click(By.cssSelector(".sign-up.cursor-pointer"));

    }

    public boolean isSignUpFormPresent() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@class='text-weight-regular text-h5']")), " Sign in to your account "));
    }

    public void fillSignUpForm(User user) {
        type(By.id("f_5788ebcb-3bfd-41c7-b94a-74ca4dbb46ef"), user.getUserName());
        type(By.xpath(" //input[@id='f_512a88d4-b1ea-4ae8-8c95-67e2f0389f47']"), user.getEmail());
        type(By.xpath("//input[@id='f_9e7ea0e8-c13b-49a3-9b60-a99257d19277']"), user.getPassword());
        selectCountryFromComboBox(By.xpath(".q-item__label"));
        type(By.xpath("//input[@id='f_9f7229b2-19c6-47f7-b78f-1912bb1a9021']"), user.getCity());
    }

    public void fillSignUpForm(String userName, String email, String password, String country, String city) {
        type(By.xpath("//input[@aria-label='Username']"), userName);
        type(By.xpath("//input[@aria-label='Email']"), email);
        type(By.xpath("//input[@aria-label='Password']"), password);
        //type(By.xpath("//input[@aria-label='Country']"), country);

        //selectCountryFromComboBox(By.xpath("//input[@aria-label='Country']"));
        selectCountryFromComboBox(By.xpath("\"//div[@class='q-field__control relative-position row no-wrap']//div[@class='q-field__control-container col relative-position row no-wrap q-anchor--skip']"));
        type(By.xpath("//input[@aria-label='State/City']"), city);
    }

    public void selectCountryFromComboBox(By locator) {

       // WebElement elementCombo = driver.findElement(By.xpath("//div[@class='q-field__control relative-position row no-wrap']//div[@class='q-field__control-container col relative-position row no-wrap q-anchor--skip']"));
        WebElement elementCombo = driver.findElement(locator);
        Rectangle rect = elementCombo.getRect();
        int x = rect.getX() + rect.getWidth() / 2;
        int y = rect.getY() + rect.getHeight() * 1 / 2;
        Actions actions = new Actions(driver);
        //actions.moveByOffset(x, y).click().perform();
        click(By.cssSelector(".q-icon.notranslate.material-icons.q-select__dropdown-icon"));

        int countryY = y - rect.getHeight() * 2;
        actions.moveByOffset(x, countryY).click().perform();

    }

    public void submitSignUpForm() {
        click(By.xpath("//button[@class='app-btn primary medium text-black']//div[1]"));
    }


    /////////////// sign In

    public void fillSignInForm(String email, String password) {
        type(By.id("email"), email);
        //id "f_712f5dd2-926a-4345-b46a-8f4449444bad"
        type(By.id("password"), password);
        //id "f_712f5dd2-926a-4345-b46a-8f4449444bad"
        //xpath //input[@id='f_e68620ab-9843-4d8a-b9f2-8ed344c45acf']
    }

    public void fillSignInForm(User data) {
        type(By.id("email"), data.getEmail());
        type(By.id("password"), data.getPassword());
    }

    public void clickOnSignIn() {
        driver.findElement(By.xpath("//button[@class='app-btn primary medium text-black']//div[1]")).submit();
    }
    ////// alert

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return false;
        else {
            driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            return true;
        }
    }

    public boolean isErrorFormatMessage() {
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password");
    }

}
