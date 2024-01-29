package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HRM_Activity6 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        // Verify Directory
        WebElement menuitem=driver.findElement(By.xpath("//div/ul/li[9]/a/b"));
        if(menuitem.isDisplayed())
        {
            menuitem.click();
        }

        //Verify header
        WebElement header= driver.findElement(By.xpath("//div[@class='head']/h1"));
        Assert.assertEquals(header.getText(),"Search Directory");

        driver.close();


    }
}
