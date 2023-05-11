package selenium_with_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CG01_TestNotation {
     /*
        Bu class icerisinde 3 test calistiralim
        1- google anasayfaya gidip, url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip title'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
     */

    WebDriver driver;


    @Test
    public void googleTest(){
        // google anasayfaya gidip, url'in google icerdigini test edin
        mahserAtlilari();
        driver.get("https://google.com");

        String expectedUrlContent = "google";
        String actualUrlContent = driver.getCurrentUrl();

        if (actualUrlContent.contains(expectedUrlContent)){
            System.out.println("Google Test PASSED");
        }else System.out.println("Google Test FAILED");

        driver.close();

    }

    @Test @Ignore
    public void wiseTest(){
        // wisequarter anasayfaya gidip title'in wisequarter icerdigini test edin
        mahserAtlilari();
        driver.get("https://wisequarter.com");

        String expectedTitleContent = "Wisequarter";
        String actualTitleContent = driver.getTitle();
        if (actualTitleContent.contains(expectedTitleContent)){
            System.out.println("Wise Test PASSED");
        }else System.out.println("Wise Test FAILED");
        driver.close();
    }

    @Test
    public void amazonTest(){
        // amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserAtlilari();
        driver.get("https://amazon.com");

        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogo.isDisplayed()){
            System.out.println("Amazon Test PASSED");
        }else System.out.println("Amazon Test FAILED");
        driver.close();


    }

    public void  mahserAtlilari(){               // Teste baslamadan once yapilmasi gerekenler bir methodta tanimlandi
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


}
