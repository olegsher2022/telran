package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginPositiveTest() {
        User user = new User("nefr42@gmail.com","Rita12345$");
        app.getUser().login(user);
        Assert.assertTrue(app.getUser().validatePopUpMessageSuccessAfterLogin());
    }


}
