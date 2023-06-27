package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exercises extends HelperBase {
    public Exercises(WebDriver driver) {
        super(driver);
    }
    public void clickOnExerciseIcon(){
        click(By.xpath("//div[@class='col'][normalize-space()='Exercises']"));
    }
    public void searchInput(String text){
        type(By.xpath("//input"),text);
        }
    public void clickOnCommonBtn() {

        click(By.xpath("//div[@class='col-12']//div[2]//div[1]"));

    }
    public void clickOnIntervalsBtn() {

        click(By.xpath("//span[normalize-space()='intervals']"));
    }
    public void clickOnTempleBtn() {
        click(By.xpath("//div[contains(text(),'Use as template')]"));
        click(By.xpath("//div[@class='app-btn__content'][normalize-space()='Preview']"));
    }

    public void majorChordBuilding() {
        click(By.xpath("//h6[text()='Major Chord Building']"));

    }

        //viewBtn //div[contains(text(),'View')]
        //playBtn //div[@class='app-btn__content'][normalize-space()='Play'] and stopBtn //div[@class='app-btn__content'][normalize-space()='Stop']

    }

