package tests;

import models.User;
import models.UserLombok;
import models.UserWith;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
@BeforeMethod
 public void precondition() {
     if (app.getUser().isLogged())
         app.getUser().logout();

 }

    @Test
    public void loginPositiveTestUser() {
        User user = new User("cherry@gmail.com","Ch12345$");
        app.getUser().login(user);
        Assert.assertTrue(app.getUser().validateSuccessLogin());


    }
//    @Test
//    public void loginPositiveTestUserWith() {
//        UserWith user2 = new UserWith()
//                .withEmail("cherry@gmail.com")
//                .withPassword("Ch12345$");
//        app.getUser().loginUserWith(user2);
//        Assert.assertTrue(app.getUser().validateSuccessLogin());
//
//    }
//    @Test
//    public void loginPositiveTestUserLombok() {
//        UserLombok user3 = UserLombok.builder()
//                .email("cherry@gmail.com")
//                .password("Ch12345$")
//                .build();
//        app.getUser().loginUserLombok(user3);
//        Assert.assertTrue(app.getUser().validateSuccessLogin());
//
//    }
    @Test
    public void loginNegativeTestWrongEmail() {
        UserLombok user3 = UserLombok.builder()
                .email("cherrygmail.com")
                .password("Ch12345$")
                .build();
        app.getUser().loginUserLombok(user3);
        Assert.assertTrue(app.getUser().isWrongFormatMessageLogin());
        Assert.assertTrue(app.getUser().isAllertPresent());

    }
    @Test
    public void loginNegativTestWrongPassword() {
        UserLombok user3 = UserLombok.builder()
                .email("cherry@gmail.com")
                .password("Ch12345")
                .build();
        app.getUser().loginUserLombok(user3);
        Assert.assertTrue(app.getUser().isWrongFormatMessageLogin());
        Assert.assertTrue(app.getUser().isAllertPresent());

    }


}
