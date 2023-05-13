package selenium_with_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CG08_iFrame_2 extends TestBase {

    // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    // sayfadaki iframe sayısını bulunuz.
    // ilk iframe'deki (Youtube) play butonuna tıklayınız.
    // ilk iframe'den çıkıp ana sayfaya dönünüz
    // ikinci iframe'deki (Jmeter Made Easy) linke 	(https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void iFrameTest02() throws InterruptedException {
        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // sayfadaki iframe sayısını bulunuz.
        int iFrameSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframe sayisi : "+iFrameSayisi);

        // ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement youtubeFrame = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeFrame);

        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        // ikinci iframe'deki (Jmeter Made Easy) linke 	(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jMeterFrame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(jMeterFrame);

        WebElement link = driver.findElement(By.xpath("/html/body/a"));
        link.click();
        Thread.sleep(2000);

    }
}
