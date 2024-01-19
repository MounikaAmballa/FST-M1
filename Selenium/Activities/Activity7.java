package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title: " + driver.getTitle());

        WebElement ball=driver.findElement(By.id("draggable"));
        WebElement zone1=driver.findElement(By.id("droppable"));
        WebElement zone2=driver.findElement(By.id("dropzone2"));

        Actions action = new Actions(driver);
        //move to dropzone1
        action.clickAndHold(ball).moveToElement(zone1).release().build().perform();
        //drag and drop to zone2
        action.dragAndDrop(ball,zone2).build().perform();
        driver.close();


    }

    }
