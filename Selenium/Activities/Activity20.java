package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.id("prompt")).click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        System.out.println("Text on alert box: "+alert.getText());
        alert.sendKeys("Awesome!");
        alert.accept();
        driver.quit();

    }

    }
