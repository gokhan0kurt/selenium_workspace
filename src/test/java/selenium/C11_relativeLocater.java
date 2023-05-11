package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C11_relativeLocater {


    //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
    //2 ) Berlin’i  3 farkli relative locator ile locate edin
    //3 ) Relative locator’larin dogru calistigini test edin

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        Thread.sleep(1500);

        // WebElement berlin = driver.findElement(By.id("pid7_thumb"));
        // berlin.click();

        WebElement nyc = driver.findElement(By.id("pid3_thumb"));
        nyc.click();
        Thread.sleep(1500);

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc) );
        berlin1.click();
        Thread.sleep(1500);

        if (berlin1.getAttribute("id").equals("pid7_thumb")){
            System.out.println("Berlin1 locate test PASSED");
        }else System.out.println("Berlin1 locate test FAILED");


        WebElement boston = driver.findElement(By.xpath("//li[@*='boston']"));
        boston.click();
        Thread.sleep(1500);
        WebElement berlin2 = driver.findElement( RelativeLocator.with(By.tagName("img")).toRightOf(boston)   );
        berlin2.click();

        if (berlin2.getAttribute("id").equals("pid7_thumb")){
            System.out.println("berlin2 locate test PASSED");
        }else System.out.println("berlin2 locate test FAILED");

        Thread.sleep(1500);
        driver.close();
    }
}
