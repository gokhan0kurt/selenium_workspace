package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        System.out.println("Baslangic pozisyonu : " + driver.manage().window().getPosition());
        System.out.println("Baslangic boyutu : " + driver.manage().window().getSize());

        Thread.sleep(1500);

        driver.manage().window().maximize();
        System.out.println("After maximize, position : " + driver.manage().window().getPosition());
        System.out.println("After maximize, size : " + driver.manage().window().getSize());
        Thread.sleep(2000);

        driver.manage().window().minimize();

        System.out.println("After minimize,  position : " + driver.manage().window().getPosition());
        System.out.println("After minimize, size :" + driver.manage().window().getSize());
        Thread.sleep(1200);

        driver.manage().window().fullscreen();
        System.out.println("After fullscreen, position" + driver.manage().window().getPosition());
        System.out.println("After fullscreen, size : " + driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().setPosition(new Point(55, 55));
        driver.manage().window().setSize(new Dimension(1000, 750));


        // driver.manage().timeouts().implicitlyWait();  once bu satirda yazdik sonra driver olusturmanin altina aldi


        Thread.sleep(5000);
        driver.close();


    }
}
