package manager;

import dto.UserDtoLombok;
import dto.UserDTO;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserHelper extends BaseHelper {

    By btnLoginNavigatorMenu = By.xpath(ConfigReader.getProperty("btnLoginNavigatorMenu"));
    By inputEmailLoginForm = By.xpath(ConfigReader.getProperty("inputEmailLoginForm"));
    By inputPasswordLoginForm = By.xpath(ConfigReader.getProperty("inputPasswordLoginForm"));
    By btnYallaLoginForm = By.xpath(ConfigReader.getProperty("btnYallaLoginForm"));
    By textSuccessLoginPopUp = By.xpath(ConfigReader.getProperty("textSuccessLoginPopUp"));
    By btnOpenRegForm = By.xpath(ConfigReader.getProperty("btnOpenRegForm"));
    By inputNameReg = By.xpath(ConfigReader.getProperty("inputNameReg"));
    By inputLastNameReg = By.xpath(ConfigReader.getProperty("inputLastNameReg"));
    By inputEmailReg = By.xpath(ConfigReader.getProperty("inputEmailReg"));
    By inputPasswordReg = By.xpath(ConfigReader.getProperty("inputPasswordReg"));
    String btnRegNewUser = ConfigReader.getProperty("btnRegNewUser");
    String btnOkPopUpStr = ConfigReader.getProperty("btnOkPopUpStr");
    By btnOkPopUp = By.xpath(ConfigReader.getProperty("btnOkPopUp"));
    By checkBoxReg = By.xpath(ConfigReader.getProperty("checkBoxReg"));
    By btnUallaReg = By.xpath(ConfigReader.getProperty("btnUallaReg"));
    By textPopUpSuccessRegH1 = By.xpath(ConfigReader.getProperty("textPopUpSuccessRegH1"));
    By btnLogout = By.xpath(ConfigReader.getProperty("btnLogout"));
    By errorMessageWrongEmailReg = By.xpath(ConfigReader.getProperty("errorMessageWrongEmailReg"));
    By errorMessageIncorrectPasswordReg = By.xpath(ConfigReader.getProperty("errorMessageIncorrectPasswordReg"));

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public boolean validatePopUpMessageSuccessAfterLogin() {
        return isTextEqual(textSuccessLoginPopUp, ConfigReader.getProperty("msgLoggedInSuccess"));
    }

    public void loginUserDtoLombok(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnOpenRegForm);
        typeTextBase(inputNameReg, user.getName());
        typeTextBase(inputLastNameReg, user.getLastName());
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickByXY(checkBoxReg, 5, 15);
        //jsClickBase(btnRegNewUser);
        clickBase(btnUallaReg);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "Registered".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);
    }

    public boolean validatePopUpMessageLoginIncorrect() {
        return isTextEqual(textSuccessLoginPopUp, ConfigReader.getProperty("msgWrongLogin"));
    }



//    solution for not exist button
    public boolean btnLogoutExist() {
        return isElementExist(btnLogout);
    }

    public void logout() {
        clickBase(btnLogout);
    }

//   solution for not exist button



    public void clickOkPopUpSuccessLogin() {
//        clickBase(btnOkPopUp);
//        clickBase(textPopUpSuccessRegH1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.textMatches(textSuccessLoginPopUp, Pattern.compile("[\\w]*")));
         jsClickBase(btnOkPopUpStr);

    }

        public boolean validateMessageIncorrectEmailReg() {
        return isTextEqual(errorMessageWrongEmailReg, "Wrong email format");
    }

    public boolean validateMessageWrongPasswordReg() {
        return isTextEqual(errorMessageIncorrectPasswordReg,
                "PASSWORD MUST CONTAIN 1 UPPERCASE LETTER, 1 LOWERCASE LETTER, 1 NUMBER AND ONE SPECIAL SYMBOL OF [@$#^&*!]");
    }

    public boolean validateErrorEmptyEmailReg() {
        return isTextEqual(errorMessageWrongEmailReg, "Email is required");
    }
}
