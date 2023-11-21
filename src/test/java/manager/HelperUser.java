package manager;

import models.User;
import models.UserWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


    public void logout() {
        clickBase(SuccessLogin);
    }

    public boolean validateSuccessLogin() {
        return isTextEqual(SuccessLogin, "Sign Out");
    }
    public boolean isLogged(){
    return isTextEqual(SuccessLogin, "Sign Out");
    }

}


