import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElement_example {

    /*
         1- Bir test class'i olusturup ilgili ayarlari yapin
         2- https://www.automationexercise.com/ adresine gidin
         3- Category bolumundeki elementleri locate edin
         4- Category bolumunde 3 element oldugunu test edin
         5- Category isimlerini yazdirin
         6- sayfayi kapatin

     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com/");

        List<WebElement> categoryElementsList =driver.findElements(By.className("panel-title"));

        int expectedCatElementsAmount = 3;
        int actualCatElementsAmount = categoryElementsList.size();

        if (expectedCatElementsAmount==actualCatElementsAmount){
            System.out.println("Elements Amount Test PASSED");
        }else System.out.println("Elements Amount Test FAILED");

        for (WebElement eachElement:categoryElementsList) {
            System.out.print(eachElement.getText() +" ");
        }

        WebElement urunBul = driver.findElement(By.partialLinkText(" Products"));

        urunBul.click();

        Thread.sleep(4000);

        driver.close();



    }

}
