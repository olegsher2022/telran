package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AplicationManager {
    WebDriver wd;
    HelperUser user;

    public void init() {
        wd = new ChromeDriver();
        user = new HelperUser(wd);

        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public HelperUser getUser() {
        return user;
    }

    public void tearDown() {
        wd.quit();
    }

}
