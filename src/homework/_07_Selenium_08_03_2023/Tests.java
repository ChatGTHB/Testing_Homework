package homework._07_Selenium_08_03_2023;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class Tests extends BaseDriver {
//    Bu web sitesine gidiniz. [http://en.wikipedia.org/wiki/FIFA_World_Cup](http://en.wikipedia.org/wiki/FIFA_World_Cup)
//
//    Contents'in içindeki Attendance'e  tıklayınız.
//
//    Attendance tablosunun içinde;
//
//    Bütün Host'ları yazdırınız.
//
//    Find elements kullanınız.
    @Test
    public void test20(){
        driver.get("http://en.wikipedia.org/wiki/FIFA_World_Cup");

        WebElement attendanceLink= driver.findElement(By.xpath("//*[@id=\"toc-Attendance\"]/a/div"));
        attendanceLink.click();

        List<WebElement> hosts= driver.findElements(By.xpath("//td[@style='text-align:left']"));

        for(WebElement host:hosts){
            System.out.println("host.getText() = " + host.getText());
        }
        System.out.println("hosts.size() = " + hosts.size());

    }
}
