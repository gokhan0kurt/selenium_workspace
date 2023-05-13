package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class CG10_SwitchingWindow extends TestBase {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    @Test
    public void switchingWindowTest() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstTabWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle= "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(2000);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(3000);

        Set<String> allWindowsWHD =driver.getWindowHandles();
        String secondTabWHD="";

        for (String eachWHD:allWindowsWHD) {
            if (!eachWHD.equals(firstTabWHD)){
                secondTabWHD=eachWHD;
            }
        }

        driver.switchTo().window(secondTabWHD);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText="New Window";
        actualText=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstTabWHD);
        Thread.sleep(2000);
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


    }
}
