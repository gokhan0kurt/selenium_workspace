package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class CG09_NewWindow extends TestBase {

    // amazon anasayfaya gidin
    // title'in Amazon kelimesi icerdigini test edin
    // yeni bir tab acarak wisequarter anasayfaya gidin
    // url'in wisequarter icerdigini test edin
    // tekrar amazon'un acik oldugu sayfaya gecin
    // ve url'in amazon icerdigini test edin

    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidin
        driver.get("https://amazon.com");
        String amazonTabWHD = driver.getWindowHandle();

        // title'in Amazon kelimesi icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // yeni bir tab acarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(1000);

        // tekrar amazon'un acik oldugu sayfaya gecin
        driver.switchTo().window(amazonTabWHD);

        // ve url'in amazon icerdigini test edin
        expectedUrl="amazon";
        actualUrl= driver.getCurrentUrl();
        Thread.sleep(2000);

    }

}
