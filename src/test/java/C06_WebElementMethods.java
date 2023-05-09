import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_WebElementMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazonda arama kutusunu locate et

        driver.get("https://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // searchBox.sendKeys("Logitech");
        //Thread.sleep(2000);

        //searchBox.submit();

        // searchBox.click();
        System.out.println(searchBox.isDisplayed());
        System.out.println(searchBox.isEnabled()); // etkilesime acik olup olmadigi sorgular

        System.out.println(searchBox.getText()); // element uzerinde bir text varsa alip getiriyor, varsa getirir

        searchBox.click();
        Thread.sleep(2000);

        searchBox.sendKeys("Logitech");
        Thread.sleep(2000);
        searchBox.clear();


        System.out.println("searchbox size : "+searchBox.getSize());

        System.out.println("searchbox tagname : "+searchBox.getTagName());

        System.out.println("searchbox location : "+searchBox.getLocation());

        Thread.sleep(3000);
        driver.close();

    }


}
