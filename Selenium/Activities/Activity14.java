package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title: " + driver.getTitle());
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr"));
        System.out.println("Number of rows: "+rows.size());
        List<WebElement> cols=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Number of cols: "+cols.size());
        WebElement cellvalue=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(cellvalue.getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        WebElement cellvalue_sort=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("After sort:"+cellvalue_sort.getText());
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for(WebElement foot : footer) {
            System.out.println(foot.getText());
        }
        driver.close();

    }

    }
