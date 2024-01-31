package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class HRM_Activity9 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        //click on My Info
        driver.findElement(By.xpath("//div/ul/li[6]/a/b")).click();
        //click on Emergency Contacts
        driver.findElement(By.xpath("//ul[@id='sidenav']/li[3]")).click();
        // Get emergency contacts
        List<WebElement> cell= driver.findElements(By.xpath( "//table[@id='emgcontact_list']/tbody/tr/td[5]"));

        for(WebElement cell1:cell)
            System.out.println(cell1.getText());

        driver.close();


























        driver.close();

    }
}
