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
    clickOnTabs();
    clickOnChords()
        selectExercisesCard();
    //list of cards  = //div[@class='exercise-card-container trim-text']
    clickOnButtonStartSixNineChord();
//body[1]/div[1]/div[1]/div[2]/main[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/button[1]
    clickOnBtnStartSetup();

    //div[@class='text-center q-pb-md']//button[@class='app-btn primary medium text-black']
    clickOnBtnSartLast();

    //button[@class='app-btn primary medium text-black']

}
