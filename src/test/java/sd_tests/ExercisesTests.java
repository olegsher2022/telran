package sd_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExercisesTests extends TestBase {
    @BeforeSuite
    public void preConditionSignIn() {
        app.getUser().clickOnContinueWithEmail();
        if (app.getUser().isSignIn()) {
            app.getUser().logout();
        }
        String email = "";
        String password = "Test123456&";
        app.getUser().fillSignInForm(email,password);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//i[normalize-space()='person']")));
    }

    @Test
    clickOnExerciesIcon();
   

}
