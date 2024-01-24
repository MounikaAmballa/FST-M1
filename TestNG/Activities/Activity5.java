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

public class Activity5 {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void before()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void checkTitle()
    {
        String title= driver.getTitle();
        System.out.println("Title: "+title);
        Assert.assertEquals(title,"Target Practice");
    }

    @Test(groups={"HeaderTests"})
    public void HeaderTest1()
    {
        WebElement header3=driver.findElement(By.id("third-header"));
        String headertext= header3.getText();
        Assert.assertEquals(headertext,"Third header");
    }

    @Test(groups={"HeaderTests"})
    public void HeaderTest2()
    {
        WebElement header5=driver.findElement(By.cssSelector("h3#third-header"));
        String headercolor=header5.getCssValue("color");
        Assert.assertEquals(headercolor,"rgb(251, 189, 8)");
    }

    @Test(groups={"ButtonTests"})
    public void ButtonTest1()
    {
        WebElement olivebutton=driver.findElement(By.cssSelector(".ui.olive.button"));
        String buttontext=olivebutton.getText();
        Assert.assertEquals(buttontext,"Olive");
    }


    @Test(groups={"ButtonTests"})
    public void ButtonTest2()
    {
        WebElement brownbutton=driver.findElement(By.cssSelector(".ui.brown.button"));
        String buttoncolor=brownbutton.getCssValue("color");
        Assert.assertEquals(buttoncolor,"rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void after()
    {

        driver.close();
    }
}
