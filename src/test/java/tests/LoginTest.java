package tests;

import models.User;
import models.UserWith;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
 @AfterMethod
 public void postcondition() {
     if (app.getUser().isLogged()) {
         app.getUser().logout();
     }
 }

    @Test
    public void loginPositiveTest() {
        User user = new User("cherry@gmail.com","Ch12345$");
        app.getUser().login(user);
        Assert.assertTrue(app.getUser().validateSuccessLogin());

    }
    @Test
    public void loginPositiveTest2() {
        UserWith user2 = new UserWith()
                .withEmail("cherry@gmail.com")
                .withPassword("Ch12345$");
        app.getUser().loginUserWith(user2);
        Assert.assertTrue(app.getUser().validateSuccessLogin());

    }




}
