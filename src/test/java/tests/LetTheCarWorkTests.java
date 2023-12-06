package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LetTheCarWorkTests extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        logger.info("preconditions");
    }

    @AfterMethod(alwaysRun = true)
    public void postconditions() {
        logger.info("postconditions");
    }

    @DataProvider(name = "carData")
    public Object[][] carData() {
        return new Object[][]{
                {"location","manufacture", "..."},

        };
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "carData", priority = 1, alwaysRun = true)
    public void positiveTest(String location, String manufacture) {
        logger.info("positiveTest");
    }
}
