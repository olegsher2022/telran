package manager;

import models.User;
import models.UserLombok;
import models.UserWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    By openLoginForm = By.xpath("//*[.='LOGIN']");
    By fillEmailLoginForm = By.xpath("//input[1]");
    By fillPasswordLoginForm = By.xpath("//input[2]");
    By submitLogin = By.xpath("//button[1]");
    By SuccessLogin = By.xpath("//*[.='Sign Out']");

public void fillLoginForm(User user) {
    typeTextBase(fillEmailLoginForm , user.getEmail());
    typeTextBase(fillPasswordLoginForm, user.getPassword());
}
    public void fillLoginFormUserWith(UserWith user) {
        typeTextBase(fillEmailLoginForm , user.getEmail());
        typeTextBase(fillPasswordLoginForm, user.getPassword());
    }
    public void fillLoginFormUserLombok(UserLombok user) {
        typeTextBase(fillEmailLoginForm , user.getEmail());
        typeTextBase(fillPasswordLoginForm, user.getPassword());
    }


    public void login(User user) {
        clickBase(openLoginForm);
         fillLoginForm(user);
        clickBase(submitLogin);
    }
    public void loginUserWith(UserWith userWith) {
        clickBase(openLoginForm);
        fillLoginFormUserWith(userWith);
        clickBase(submitLogin);
    }
    public void loginUserLombok(UserLombok userLombok) {
        clickBase(openLoginForm);
     fillLoginFormUserLombok (userLombok);
        clickBase(submitLogin);
    }



    public void logout() {
        clickBase(SuccessLogin);
    }

    public boolean validateSuccessLogin() {
        return isTextEqual(SuccessLogin, "Sign Out");
    }
    public boolean isLogged(){

    return isElementPresent(By.xpath("//*[.='Sign Out']"));
        }

    public boolean isAllertPresent() {
        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert== null)
            return false;
        wd.switchTo().alert();
        //  System.out.println(alert.getText());
        alert.accept();
        return true;
    }
    public boolean isWrongFormatMessageLogin() {
        Alert alert= new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password");

    }
    public boolean isWrongFormatMessageRegistrPage() {
        Alert alert= new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password format");

    }


}


