package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class CG11_ActionsClassEx extends TestBase {
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    //3- Cizili alan uzerinde sag click yapin
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim



    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstTabWHD = driver.getWindowHandle();
        Thread.sleep(1000);

        //3- Cizili alan uzerinde sag click yapin
        Actions act = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));

        act.contextClick(ciziliAlanElementi).perform();
        Thread.sleep(2000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> allTabsWHD = driver.getWindowHandles();
        String secondTabWHD = "";

        for (String eachWHD:allTabsWHD) {
            if (!firstTabWHD.equals(eachWHD)){
                secondTabWHD = eachWHD;
            }
        }
        driver.switchTo().window(secondTabWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        expectedText="Elemental Selenium";
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(3000);


    }

}
