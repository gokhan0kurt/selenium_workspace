package selenium_with_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CG05_DropdownMenu {

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 4 olduğunu test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void test01() throws InterruptedException {
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select slt = new Select(dropdownElement);
        slt.selectByIndex(1);
        Thread.sleep(1500);

        System.out.println(slt.getFirstSelectedOption().getText());
        System.out.println("======================================");

        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        slt.selectByValue("2");
        Thread.sleep(1500);
        System.out.println(slt.getFirstSelectedOption().getText());
        System.out.println("======================================");

        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        slt.selectByVisibleText("Option 1");
        Thread.sleep(1500);
        System.out.println(slt.getFirstSelectedOption().getText());
        System.out.println("======================================");

        //	4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownValues = slt.getOptions();

        for (WebElement eachElement:dropdownValues) {
            System.out.println(eachElement.getText());
        }

        //	5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedSize = 4;
        int actualSize = dropdownValues.size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    @After
    public void teardown(){
        driver.close();
    }
}
