package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CG12_ActionsClass extends TestBase {


    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeButton = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHereBox = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions act =new Actions(driver);
        act.dragAndDrop(dragMeButton,dropHereBox).perform();
        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText = "Dropped!";
        String actualText = dropHereBox.getText();

        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);


    }
}
