package sd_tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {
    public static ApplicationManager app=new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod
    public void started(Method method){
        logger.info("   ### Start test " + method.getName());
    }

    @AfterMethod
    public void finished(){

        logger.info("   ### Finished ###");

    }
}
