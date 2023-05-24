package selenium_with_JUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class CG21_PageScreenShot extends TestBase {
    // amazon anasayfaya gidelim
    // Nutella aratalim
    // Sonuclarin Nutella icerdigini test edelim
    // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim

    @Test
    public void amazzonTest01() throws IOException {

        // amazon anasayfaya gidelim
        driver.get("https://amazon.com");

        // Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        String expectedResult = "Nutella";
        String actualResult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/screenshots/tumSayfaResim.png");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaResim);

    }

}
