package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_DriverGet {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        System.out.println("Page Title : "+ driver.getTitle());


        System.out.println("URL : "+driver.getCurrentUrl());

        System.out.println("Page handle code (hash) : "+driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());

        Thread.sleep(2000);
        driver.close();


    }
}
