package selenium_with_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class CG19_WebTable extends TestBase {

    // "https://www.amazon.com" adresine gidin
    //  Sayfanin en altina inin
    //  Web table tum body’sini yazdirin
    //  Web table’daki satir sayisinin 9 oldugunu test edin
    //  Tum satirlari yazdirin
    //  Web table’daki sutun sayisinin 13 olduğunu test edin
    //  5.sutunu yazdirin
    //  Satir ve sutun sayisini parametre olarak alip,
    //  hucredeki bilgiyi döndüren bir method olusturun

    @Test
    public void webtableTest() throws InterruptedException {

        // "https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //  Sayfanin en altina inin
        Actions action = new Actions(driver);
        action.keyDown(Keys.END).perform();
        Thread.sleep(1000);

        //  Web table tum body’sini yazdirin
        List<WebElement> bodyElements = driver.findElements(By.tagName("tbody"));

        for (WebElement eachElement : bodyElements) {
            System.out.println(eachElement.getText());
        }
        System.out.println("-----------------------------------");


        //  Web table’daki satir sayisinin 9 oldugunu test edin
        int expectedRowSize = 9;
        int actualRowSize = driver.findElements(By.xpath("//table/tbody/tr")).size();

        Assert.assertEquals(expectedRowSize, actualRowSize);

        //  Tum satirlari yazdirin
        List<WebElement> allRows = driver.findElements(By.xpath("//table/tbody/tr"));
        int satirNo = 1;
        for (WebElement eachRow : allRows) {
            System.out.println(satirNo +". satir");
            System.out.println(eachRow.getText());
            System.out.println("===================");
            satirNo++;
        }

        //  Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> allDataColumn = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));

        int expectedDataColumn = 13 ;
        int actualDataColumn = allDataColumn.size();

        Assert.assertEquals(expectedDataColumn,actualDataColumn);

        //  5.sutunu yazdirin
        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//td[5]"));
        for (WebElement each5element:besinciSutunElementleri) {
            System.out.println(each5element.getText());
            System.out.println("--------------------------");
        }

        System.out.println("**********************************");
        //  Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun

        dataGetir(3,7);


    }

    private void dataGetir(int rowNo , int tDataNo) {
        WebElement arananElement = driver.findElement(By.xpath("//table/tbody/tr["+rowNo+"]/td["+tDataNo+"]"));
        System.out.println(arananElement.getText());

    }


}
