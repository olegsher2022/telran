package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@Listeners(TestNGListener.class)
public class BaseTest {
    static ApplicationManager app = new ApplicationManager();
    RandomUtils randomUtils = new RandomUtils();
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    boolean flagLogin = false, flagPopUp = false;


    UserDtoLombok userDtoLombok = UserDtoLombok
            .builder()
            .email("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

    public void logoutIflogin() {
        if (app.getUserHelper().btnLogoutExist()) {
            app.getUserHelper().logout();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("start test" + m.getName());
        logger.info("started method with params: " + Arrays.toString(m.getParameters()));
    }

    @AfterMethod(alwaysRun=true)
    public void endLogger(Method m){
        logger.info("End of test:" + m.getName());
        logger.info("end method with params: " + Arrays.toString(m.getParameters()));
    }

}
