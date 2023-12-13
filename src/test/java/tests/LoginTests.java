package tests;

import dto.UserDTO;
import dto.UserDtoLombok;
import dto.UserDTOWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import static io.qameta.allure.SeverityLevel.*;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import utils.ConfigProperties;


public class LoginTests extends BaseTest {
    Logger logger = LoggerFactory.getLogger(LoginTests.class);

//    @BeforeTest
    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        logoutIflogin();
    }


//    @AfterTest
    @AfterMethod(alwaysRun = true)
    public void postconditionsLogin() {
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test(groups = {"smoke", "regression"})
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        BaseTest.app.getUserHelper().login(userDTO);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test(description = "positiveLoginUserDTOWith", groups = {"smoke", "regression"})
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");
        BaseTest.app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test
    public void positiveLogin() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

   @Test(groups = {"smoke", "regression"})
   public void positiveLogin1() {
       app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        try {
           Thread.sleep(1);
       } catch (InterruptedException e) {
            logger.error(String.valueOf(e));
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
        logger.info("Test Finished");
   }



    @Test(priority = 1)
    public void negativePasswordWithoutSymbol() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aaa")
                .build();
        logger.info("testqa20@gmail.com");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }

    @Test(priority = 1)
    public void negativePasswordWithoutNumbers() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("ddsdhjAa$")
                .build();
        logger.warn("userDtoLombok initialization finished");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect(), "Fail");
        logger.info("Pass");

    }

    @Test(priority = 1)
    public void negativePasswordWithoutLetters() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("12345678$")
                .build();
        logger.warn("userDtoLombok initialization finished again with warn");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);

         Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }


}
