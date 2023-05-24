package selenium_with_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class CG20_WebTable extends TestBase {

    //   “https://demoqa.com/webtables” sayfasina gidin
    //   Headers da bulunan basliklari yazdirin
    //   3.sutunun basligini yazdirin
    //   Tablodaki tum datalari yazdirin
    //   Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    //   Tablodaki satir sayisini yazdirin
    //   Tablodaki sutun sayisini yazdirin
    //   Tablodaki 3.kolonu yazdirin
    //   Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //    bir method olusturun,
    //    satir ve sutun sayisini girdigimde bana datayi yazdirsin

    @Test
    public void webTableTest02() {

        //   “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //   Headers da bulunan basliklari yazdirin
        List<WebElement> headers = driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (WebElement eachHeader : headers) {
            System.out.println(eachHeader.getText());
        }
        System.out.println("=====================");

        //   3.sutunun basligini yazdirin
        System.out.println("3. sutun basligi : " + headers.get(2).getText());

        //   Tablodaki tum datalari yazdirin

        List<WebElement> allDatas = driver.findElements(By.xpath("//div[@role='gridcell']"));
        int notNullData = 0;
        for (WebElement eachData : allDatas) {

            if (!eachData.getText().isBlank()) {
                System.out.println(eachData.getText());
                notNullData++;
            }

        }

        System.out.println("===========================================");
        //   Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Not null data size : " + notNullData);

        //   Tablodaki satir sayisini yazdirin
        System.out.println("satir sayisi : " + driver.findElements(By.xpath("//div[@role='rowgroup']")).size());

        //   Tablodaki sutun sayisini yazdirin
        System.out.println("sutun sayisi : " + headers.size());
        System.out.println("===========================================");

        //   Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunElementelri = driver.findElements(By.xpath("//div[@role='row']/div[3]"));

        for (int i = 1; i < ucuncuSutunElementelri.size(); i++) {

            if (!ucuncuSutunElementelri.get(i).getText().isBlank()) {
                System.out.println(ucuncuSutunElementelri.get(i).getText());
            }

        }

        //   Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin // (//div[@role='row'])[4]/div[1]

        for (int i = 2; i < headers.size(); i++) {
            WebElement name = driver.findElement(By.xpath(getDynamicxPath(i, 1)));

            if (name.getText().equalsIgnoreCase("Kierra")) {
                WebElement salary = driver.findElement(By.xpath(getDynamicxPath(i, 5)));
                System.out.println("Kierra'nin maasi : "+salary.getText());
            }

        }


        //    bir method olusturun,
        //    satir ve sutun sayisini girdigimde bana datayi yazdirsin

        dataYazdir(3,4);

    }

    private void dataYazdir(int rowNo, int dataNo) {

        WebElement istenenElement = driver.findElement(By.xpath(getDynamicxPath(rowNo, dataNo)));
        System.out.println("Istenen Element : "+istenenElement.getText());

    }

    private String getDynamicxPath(int rowNo, int dataNo) {

        return "(//div[@role='row'])[" + rowNo + "]/div[" + dataNo + "]";
    }


}
