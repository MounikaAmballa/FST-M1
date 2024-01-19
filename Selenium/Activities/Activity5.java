package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title: "+driver.getTitle());
        Actions action=new Actions(driver);
        //left click
        action.click().build().perform();
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println("left click: "+frontText);
        //double click
        action.doubleClick().build().perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println("double click: "+frontText);
        //right click
        action.contextClick().build().perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println("right click: "+frontText);
        driver.close();






    }

    }
