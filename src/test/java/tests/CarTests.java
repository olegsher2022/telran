package tests;

import dto.AddCarDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class CarTests extends BaseTest{
    @BeforeClass
    public void loginPreConditions() {
        app.navigateToMainPage();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test
    public void addNewCarTest() {

        Random random = new Random();
        String serNumber = String.valueOf(Math.round(random.nextFloat() * Math.pow(10,12)));
        AddCarDTO car = AddCarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("opelqa20")
                .model("corsa")
                .year(1999)
                .fuel("Diesel")
                .seats(2)
                .carClass("jsdfh")
                .pricePerDay(20)
                .city("Tel Aviv")
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
