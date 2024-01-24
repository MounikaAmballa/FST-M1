package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void before()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net");
    }
    @Test
    public void testmethod()
    {
        String title_actual=driver.getTitle();
        System.out.println(title_actual);
        String title_expected="Training Support";
        Assert.assertEquals(title_actual,title_expected);
        driver.findElement(By.id("about-link")).click();
        System.out.println("New Title: "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }
    @AfterClass
    public void after()
    {
        driver.close();
    }
}
