package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CG13_ActionsClassEx extends TestBase {

    //1- https://www.amazon.com/ adresine gidin
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    //   mouse’u bu menunun ustune getirin
    //3- “Create a list” butonuna basin
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin


    @Test
    public void amazonAccountListTest01() throws InterruptedException {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(1500);

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        WebElement accountListsElement = driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        Actions act =new Actions(driver);
        act.moveToElement(accountListsElement).perform();
        Thread.sleep(1000);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(1500);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedText ="Your Lists";
        String actualText =driver.findElement(By.xpath("//*[@id='my-lists-tab']")).getText();
        Assert.assertEquals(expectedText,actualText);


    }
}
