package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title: " + driver.getTitle());
        List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("Number of rows: "+rows.size());
        List<WebElement> cols=driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        System.out.println("Number of rows: "+cols.size());
        List<WebElement> cell_3rdrow=driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        System.out.println("Values in 3rd row");
        for(int i=0;i< cell_3rdrow.size();i++)
        {
            System.out.println(cell_3rdrow.get(i).getText());
        }
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row and second cell value: " + cellValue.getText());
        driver.close();

    }

    }
