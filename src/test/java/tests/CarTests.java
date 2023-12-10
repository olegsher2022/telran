package tests;

import dto.AddCarDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarTests extends BaseTest{
    @BeforeClass
    public void loginPreConditions() {
        app.navigateToMainPage();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test
    public void addNewCarTest() {
//        String serNumber = randomUtils.generateStringDigits(12);
        AddCarDTO car = AddCarDTO.builder()
                .serialNumber("123456789012")
                .manufacture("opelqa20")
                .model("corsa")
                .year(1999)
                .fuel("Diesel")
                .seats(2)
                .carClass("jsdfh")
                .pricePerDay(20)
                .city("Jerusalem")
                .build();
        // Tel Aviv, Israel
        app.getCarHelper().clickAddNewCar();
        app.getCarHelper().fillFormNewCar(car);
        Assert.assertTrue(app.getCarHelper().validateMessagePopUp());
    }

    @AfterClass
    public void logoutAfterConditions() {
        app.getCarHelper().clickAddNewCarPopUp();
        app.getUserHelper().logout();
        app.navigateToMainPage();
    }
}
