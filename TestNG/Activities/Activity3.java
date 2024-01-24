package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void before()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void login()
    {
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
        WebElement message=driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals("Welcome Back, admin",message.getText());

    }

    @AfterClass
    public void after()
    {
        driver.close();
    }
}
