package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");
        BaseTest.app.getUserHelper().login(userDTO);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");
        BaseTest.app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test
    public void positiveLogin() {
        UserDTOLombok userDtoLombok = UserDTOLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }


}
