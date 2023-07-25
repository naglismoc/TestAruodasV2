import org.example.Land;
import org.example.Purpose;
import org.example.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandTests {

    @Test
    public void makeAdPositiveTest(){
        Land ad = new Land("Klaipėda","Debrecenas","+37063500879","20","60000 f", new String[]{Purpose.miskuUkio,Purpose.namuValda});
        ad.fillAd();
        //deleteAd();
    }
    public void deleteAd(){
        //trina
    }
    @BeforeClass
    public void beforeClass(){
        Utils.driver = new ChromeDriver();
        Utils.driver.manage().window().maximize();
        Utils.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Utils.wait = new WebDriverWait(Utils.driver, Duration.ofSeconds(5));
        Utils.acceptCookies();
        Utils.login();
    }

    @AfterClass
    public void afterClass(){
        // driver.quit();
    }
}
