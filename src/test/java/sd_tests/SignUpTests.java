package sd_tests;

import org.testng.annotations.Test;
import models.User;



public class SignUpTests extends TestBase{
    @Test
    public void signUpPositive(){
        logger.info("Method addNewCarPositive started");
         /*User user = User.builder()
                 .userName("test")
                 .email("test1@gmail.com")
                 .password("Test123456&")
                 .country("United States")
                 .city("Toronto")
                 .build();*/
        app.getUser().clickOnContinueWithEmail();
        app.getUser().pause(3000);
        app.getUser().clickOnSignUpBtn();

        app.getUser().fillSignUpForm("test","test1@gmail.com","Test123456&","United States","Toronto");
        app.getUser().submitSignUpForm();

        logger.info("User was signed up");
    }

}
