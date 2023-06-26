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
    public void clickOnContinueWithEmail() {
        //click(By.cssSelector("button[class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--rectangle q-btn--rounded bg-white text-white q-btn--actionable q-focusable q-hoverable full-width row text-black'] span[class='col']"));
        click(By.xpath("//span[contains(text(),'Continue with Email')]"));
    }
    /////////////// sign In ////////////////////////////////

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        click(By.xpath("//div[@role='listitem']//div[@class='q-focus-helper']"));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='bg-primary']"))));

        click(By.xpath("//div[@class='app-btn__content'][normalize-space()='Yes']"));

        //Are you sure? yesBtn: //div[@class='app-btn__content'][normalize-space()='Yes']
        //yesBtn css div[class='col'] button[class='app-btn secondary medium text-black'] div[class='app-btn__content']
        //menu btn //button[2]//span[2]
        //menuHome  css a[class='q-item q-item-type row no-wrap q-item--dark q-router-link--exact-active active-route q-item--clickable q-link cursor-pointer q-focusable q-hoverable col'] div[class='q-item__section column q-item__section--main justify-center']
        //menuExercises //div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Exercises']
        //menuWorkouts //div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Workouts']
        //menuSongs //div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Songs']
        //menuRecorder //div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Recorder']
        //settings //body[1]/div[1]/div[1]/header[1]/div[1]/button[2]/span[2]


    }
    /*public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
//        WebElement element = wd.findElement(
//                By.cssSelector(".dialog-container"));
//        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.cssSelector(""))));
//        System.out.println(element.getText());
        return driver.findElement(
                By.cssSelector("")).getText().contains("success");
    }*/
    public String getTextFromMessage(){
        return driver.findElement(By.cssSelector("   ")).getText();
    }
    public boolean isElementPresent(By locator){

        return (driver.findElements(locator).size() > 0);
    }
    public boolean isSignIn(){
        return isElementPresent(By.xpath("//div[@role='listitem']//div[@class='q-focus-helper']"));
    }

    public void clickOnSignIn() {
        driver.findElement(By.xpath("//button[@class='app-btn primary medium text-black']//div[1]")).submit();
    }

    public void fillSignInForm(String email, String password) {
        type(By.xpath("//input[@aria-label='Email']"),email);
        type(By.xpath("//input[@aria-label='Password']"),password);
        click(By.xpath("//button[@class='app-btn primary medium text-black']//div[1]"));
        pause(10);
    }

    public void fillSignInForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
    public void fillEmailIncorrect(User user) {
        if(isElementPresent(By.xpath("//input[@aria-label='Email']"))){
            click(By.xpath("//input[@aria-label='Email']"));
            type(By.xpath("//input[@aria-label='']"), user.getEmail());

        }
    }
    public void fillPasswordIncorrect(User user) {
        String password = user.getPassword();
        type(By.xpath("//input[@aria-label='Password']"),password);
        click(By.xpath("//button[@class='app-btn primary medium text-black']//div[1]"));

    }

    ////////////// sign Up //////////////////////////////////////////////

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


    ////// alert ///////////////////////////////////////////////////////////////

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
