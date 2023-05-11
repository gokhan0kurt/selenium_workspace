package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_FirstTest {

     /*
            1- Amazon sayfasina gidelim. https://www.amazon.com/
            2- Sayfa basligini(title) yazdirin
            3- Sayfa basliginin “Amazon” icerdigini test edin
            4- Sayfa adresini(url) yazdirin
            5- Sayfa url’inin “amazon” icerdigini test edin.
            6- Sayfa handle degerini yazdirin
            7- Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
            8- Sayfayi kapatin.
      */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1- Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // 2- Sayfa basligini(title) yazdirin
        String pageTitle = driver.getTitle();
        System.out.println("Page Title : "+pageTitle);

        // 3- Sayfa basliginin “Amazon” icerdigini test edin
        String expectedTitleContent = "Amazon";
        String actualTitleContent = pageTitle;

        if (actualTitleContent.contains(expectedTitleContent)){
              System.out.println("HTML Test PASSED");
        }else System.out.println("HTML Test FAILED");

        Thread.sleep(2000);
        driver.close();



    }




}
