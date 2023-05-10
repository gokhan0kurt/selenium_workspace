import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C10_cssLocater {
    //2-  https://www.amazon.com/ adresine gidin
    //3-  Browseri tam sayfa yapin
    //4-  Sayfayi “refresh” yapin
    //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    //6-  Gift Cards sekmesine basin
    //7-  Birthday butonuna basin
    //8-  Best Seller bolumunden ilk urunu tiklayin
    //9-  Gift card details’den 25 $’i  secin
    //10- Urun ucretinin 25$ oldugunu test edin
    //11- Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.gecko.driver","src/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        Thread.sleep(1000);

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        Thread.sleep(1000);

        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle = "Spend less";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title Check Test PASSED");
        }else System.out.println("Title Check Test FAILED");


        //6-  Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        Thread.sleep(1000);

        //7-  Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        Thread.sleep(1000);

        //8-  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(1000);

        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();
        Thread.sleep(1500);

        //10- Urun ucretinin 25$ oldugunu test edin
        String expectedValue = "25$";
        String actualValue = (driver.findElement(By.cssSelector("span[class='a-color-price a-text-bold']")).getText());

        System.out.println(driver.findElement(By.cssSelector("span[class='a-color-price a-text-bold']")).getText());

        if (expectedValue.equals(actualValue)){
            System.out.println("Gift Card Value Test PASSED");
        }else System.out.println("Gift Card Value Test FAILED");


        //11- Sayfayi kapatin
        Thread.sleep(1500);
        driver.close();

    }
}
