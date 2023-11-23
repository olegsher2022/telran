package tests;

import dto.UserDTOLombok;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

public class BaseTest {
    static ApplicationManager app = new ApplicationManager();
    RandomUtils randomUtils = new RandomUtils();

    UserDTOLombok userDtoLombok = UserDTOLombok.builder()
            .email("testqa20@gmail.com")
           .password("123456Aa$")
           .build();

    @BeforeSuite
    public void setup() {
        app.init();
    }
    @AfterSuite
    public void stop() {
        app.tearDown();
    }

    public void logoutIflogin() {
        if (app.getUserHelper().btnLogoutExist()) {
            app.getUserHelper().logout();
        }
    }

}
