package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args)  {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.tagName("a")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Number of handles: "+driver.getWindowHandles());
        for(String handle:driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Newly opened tab " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Heading: "+ driver.findElement(By.className("content")).getText());

        driver.findElement(By.id("actionButton")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switch focus
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("Current tab: " + driver.getWindowHandle());
         System.out.println("Page title: " + driver.getTitle());
        System.out.println(driver.findElement(By.className("content")).getText());
        driver.quit();

    }

    }
