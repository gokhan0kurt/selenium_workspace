package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBAClasses;

public class CG06_JSalerts extends TestBaseBAClasses {

     /*
            3 test method'u olusturup asagidaki gorevi tamamlayin
        1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
        2.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim

     */


    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        // 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(1000);

        // OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        //2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);

        //Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.switchTo().alert().dismiss();
        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedResultText,actualResultText);

    }

    @Test
    public void test03() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        // Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(2000);

        // OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String expectedResult= "Abdullah";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));


    }

}
