package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    @AfterMethod
    public void postconditionsLogin() {
        if(flagPopUp) {
            flagPopUp = false;
            app.getUserHelper().clickOkPopUpSuccessLogin();
        }
        if(flagLogin) {
            flagLogin = false;
            app.getUserHelper().logout();
        }
    }

    @Test(groups={"regression"})
    public void positiveRegistration() {
        app.getUserHelper().refreshPage();
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flagLogin = true;
        flagPopUp = true;
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }

    @Test(enabled = false)
    public void negativeRegistrationWrongEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("abc@")
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getUserHelper().validateMessageIncorrectEmailReg());
    }

    @Test(groups = {"smoke", "regression"}, enabled = false)
    public void negativeRegistrationWrongPassword() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getUserHelper().validateMessageWrongPasswordReg());
    }

    @Test
    public void negativeRegistrationBlankEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("")
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getUserHelper().validateErrorEmptyEmailReg());
    }
}