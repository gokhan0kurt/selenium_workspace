import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C13_GoogleNutellaSearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(1500);

        // cookies uyarisini kabul ederek kapatin

        // Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Test PASSED");
        }else System.out.println("Title Test FAILED");

        // Arama cubuguna “Nutella” yazip aratin
        WebElement googleSearchBox = driver.findElement(By.id("APjFqb"));
        googleSearchBox.click();
        Thread.sleep(1000);
        googleSearchBox.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(1000);

        // Bulunan sonuc sayisini yazdirin
        String searchResult = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Result : "+searchResult);

        // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        // Result : Yaklaşık 123.000.000 sonuç bulundu (0,47 saniye)

        String [] resultsArr = searchResult.split(" ");
        String str =resultsArr[1];
        str=str.replaceAll("\\D","");

        int actualResult = Integer.parseInt(str);
        System.out.println("Actual search result : "+actualResult);

        int expectedResult = 10000000;

        if (actualResult>expectedResult){
            System.out.println("Search Result Test PASSED");
        }else System.out.println("Search Result Test FAILED");


        // Sayfayi kapatin
        Thread.sleep(1000);
        driver.close();

    }

}
