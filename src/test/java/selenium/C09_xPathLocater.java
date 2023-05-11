package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_xPathLocater {

    //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //2- Add Element butonuna basin
    //3- Delete butonu’nun gorunur oldugunu test edin
    //4- Delete tusuna basin
    //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1 //
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Thread.sleep(1500);

        WebElement deleteButton =driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete Button Test PASSED");
        }else System.out.println("Delete Button Test FAILED");

        deleteButton.click();
        Thread.sleep(1500);

        if (driver.findElement(By.xpath("//*[.='Add/Remove Elements']")).isDisplayed()){
            System.out.println("Test-2 PASSED");
        }else System.out.println("Test-2 FAILED");

        Thread.sleep(1500);

        driver.close();

    }
}
