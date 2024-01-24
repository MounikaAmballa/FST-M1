package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeClass
    public void before()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username","password"})
    public void login(String username,String password)
    {
        WebElement uname= driver.findElement(By.id("username"));
        WebElement pwd= driver.findElement(By.id("password"));
        uname.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterClass
    public void after()
    {

        driver.close();
    }
}
