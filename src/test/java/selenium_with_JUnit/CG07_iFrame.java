package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CG07_iFrame extends TestBase {


    //  https://the-internet.herokuapp.com/iframe adresine gidin.
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //  ve  konsolda yazdirin.
    //  Text Box’a “Merhaba Dunya!” yazin.
    //  TextBox’in altinda bulunan “Elemental Selenium”
    //  linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.



    @Test
    public void iFrameTest() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isEnabled());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //	- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);


        WebElement frameTextBox = driver.findElement(By.id("tinymce"));
        Thread.sleep(3000);
        frameTextBox.clear();
        Thread.sleep(2000);
        frameTextBox.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);

        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        driver.switchTo().defaultContent();

        WebElement actualText = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Assert.assertTrue(actualText.isDisplayed());
    }
}
