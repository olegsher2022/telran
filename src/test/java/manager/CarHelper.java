package manager;

import dto.AddCarDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.CarConfigReader;

import javax.swing.*;

public class CarHelper extends BaseHelper{
    public CarHelper(WebDriver driver) {
        super(driver);
    }

    By inputLocation = By.xpath(CarConfigReader.getProperty("inputLocationXPath"));
    By manufacture = By.id(CarConfigReader.getProperty("manufactureId"));
    By model = By.id(CarConfigReader.getProperty("model"));
    By btnAddNewCarMenu = By.id(CarConfigReader.getProperty("btnAddNewCarMenu"));
    By textPopupTitle = By.xpath(CarConfigReader.getProperty("textPopupTitle"));



    public void fillFormNewCar(AddCarDTO car){
        enterLocationWithAutocomplete(car.getCity());
        typeTextBase(manufacture, car.getManufacture());
        typeTextBase(model, car.getModel());

    }
    public void clickAddNewCar(){
        clickBase(btnAddNewCarMenu);
    }


    private void enterLocationWithAutocomplete(String city) {
        typeTextBase(inputLocation, city);
        selectFirstOptionFromGooglePlacesDropdown();
    }

    private void selectFirstOptionFromGooglePlacesDropdown() {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public boolean validateMessagePopup(){
        return isTextEqual(textPopupTitle,"Car added".trim().toUpperCase());
    }
}
