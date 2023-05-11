package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_LocaterExample {



    //	1- https://www.amazon.com/ sayfasına gidin.
    //  2- Arama kutusuna “city bike” yazip aratin
    //	3- Görüntülenen sonuçların sayısını yazdırın
    //	4- Listeden ilk urunun resmine tıklayın.


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("city bike" + Keys.ENTER);

        WebElement aramaSonuclari=driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonuclari.getText());

        WebElement ilkUrun =driver.findElement(By.className("s-image"));
        ilkUrun.click();

        Thread.sleep(4500);
        driver.close();

    }
}
