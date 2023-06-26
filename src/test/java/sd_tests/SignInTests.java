package sd_tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnContinueWithEmail();
        if (app.getUser().isSignIn()) {
            app.getUser().logout();
        }
    }
    @Test
    public void signInSuccess() {
        String email = "petrkislansky@gmail.com";
        String password = "Test123456&";
        app.getUser().fillSignInForm(email,password);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//i[normalize-space()='person']")));
    }

  /*  @Test(dataProvider = "wrongEmailData", dataProviderClass = ProviderData.class)
    public void loginNegativeWrongEmailTest(User user){
        //User user=User.builder().email("petrkislansky@gmail.com").password("Test123456&").build();
        app.getUser().fillEmailIncorrect(user);
        app.getUser().pause(10);
        app.getUser().fillPasswordIncorrect(user);

        Assert.assertFalse(app.getUser().isSignIn());
        // Assert.assertTrue(app.getUser().getTextFromErrorEmailMessage().contains("There isn't an account for this username") );
        //<p class="error-message">There isn't an account for this username</p>
        app.getUser().returnToHome();

    }*/
}
