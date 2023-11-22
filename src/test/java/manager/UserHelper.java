package manager;

import dto.UserDTOLombok;
import dto.UserDTO;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By inputEmailLoginForm = By.xpath("//input[@id='email']");
    By inputPasswordLoginForm = By.xpath("//input[@id='password']");
    By btnYallaLoginForm = By.xpath("//button[@type='submit']");
    By textSuccessLoginPopUp = By.xpath("//h2[@class='message']");
    By btnOpenRegForm = By.xpath("//a[contains(@href, '/registration')]");
    By inputNameReg = By.xpath("//input[@id='name']");
    By inputLastNameReg = By.xpath("//input[@id='lastName']");
    By inputEmailReg = By.xpath("//input[@id='email']");
    By inputPasswordReg = By.xpath("//input[@id='password']");
    String btnRegNewUser = "document.querySelector('#terms-of-use').click();";
//    By checkBoxReg = By.xpath("//label[@for='name']");
    By checkBoxReg = By.xpath("//label[@for='terms-of-use']");
    By btnUallaReg = By.xpath("//button[@type='submit']");
    By textPopUpSuccessRegH1 = By.xpath("//div[@class='dialog-container']//h1[@class='title']");

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
        return isTextEqual(textSuccessLoginPopUp, "Logged in success");
    }

    public void loginUserDtoLombok(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void fillRegistrationForm(UserDTOLombok user) {
        clickBase(btnOpenRegForm);
        typeTextBase(inputNameReg, user.getName());
        typeTextBase(inputLastNameReg, user.getLastName());
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickByXY(checkBoxReg, 10, 12);
        //jsClickBase(btnRegNewUser);
        clickBase(btnUallaReg);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "Registered".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);
    }
}
