package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_AutomationExercise {

    /*
        1- Bir test class'i olusturun ilgili ayarlari yapin
        2- https://automationexercise.com/ adresine gidin
        3- Sayfada 147 adet link bulundugunu test edin
        4- Products linkine tiklayin
        5- special offer yazisinin gorundugunu test edin
        6- sayfayi kapatin

      */

    public static void main(String[] args) throws InterruptedException {

        // 1 //
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2 //
        driver.get("https://automationexercise.com/");

        // 3 //

        List<WebElement> pageAllLinkList = driver.findElements(By.tagName("a"));

        int expectedLinkSize = 147;
        int actualLinkSize = pageAllLinkList.size();

        if (expectedLinkSize == actualLinkSize) {
            System.out.println("Link amount test PASSED");
        } else System.out.println("Link amount test FAILED");


        // 4 //

        WebElement productsLink = driver.findElement(By.partialLinkText("Products"));
        productsLink.click();

        WebElement specialOfferText = driver.findElement(By.id("sale_ima ge"));
        System.out.println(specialOfferText.isDisplayed());

        Thread.sleep(2000);
        driver.close();


    }
}
