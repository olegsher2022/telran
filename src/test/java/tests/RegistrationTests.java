package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    @Test
    public void positiveRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }

    //NEGATIVE REGISTRATION
    @Test
    public void negativeRegistrationWrongEmail() {
        UserDTOLombok user = UserDTOLombok.builder()
                .email("abc@")
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageIncorrectEmailReg());
    }

    @Test
    public void negativeRegistrationWrongPassword() {
        String email = randomUtils.generateEmail(7);

        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("123456Aa")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageWrongPasswordReg());
    }

    @Test
    public void negativeRegistrationBlankEmail() {
        UserDTOLombok user = UserDTOLombok.builder()
                .email("")
                .password("123456Aa$")
                .lastName("abdfg")
                .name("test")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateErrorEmptyEmailReg());
    }
}