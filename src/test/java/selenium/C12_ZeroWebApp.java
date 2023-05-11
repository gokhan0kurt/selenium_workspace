package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C12_ZeroWebApp {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(1500);

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(1500);

        //3. Login alanine  “username” yazdirin
        WebElement loginArea =driver.findElement(By.name("user_login"));
        loginArea.sendKeys("username");
        Thread.sleep(1500);

        //4. Password alanina “password” yazdirin
        WebElement passwordArea = driver.findElement(By.id("user_password"));
        passwordArea.sendKeys("password");
        Thread.sleep(1500);

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1300);


        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        Thread.sleep(1300);

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        Thread.sleep(1300);
        driver.findElement(By.id("pay_bills_link")).click();
        Thread.sleep(1300);

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("350");
        Thread.sleep(1500);

        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("(//input[@required='required'])[2]")).sendKeys("2020-09-10");
        Thread.sleep(1500);

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(1500);

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        if ( driver.findElement(By.id("alert_container")).isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        Thread.sleep(2000);
        driver.close();

    }
}
