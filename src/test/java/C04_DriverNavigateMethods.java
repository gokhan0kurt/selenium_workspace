import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DriverNavigateMethods {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        Thread.sleep(1500);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
        Thread.sleep(2500);

        driver.navigate().to("https://wisequarter.com");
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        driver.navigate().forward();
        Thread.sleep(2500);

        driver.navigate().refresh();
        Thread.sleep(2500);

        driver.close();
    }
}
