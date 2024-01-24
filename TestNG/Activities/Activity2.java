package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;


public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void before()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void test1()
    {
        String title_actual=driver.getTitle();
        System.out.println(title_actual);
        String title_expected="Target Practice";
        Assert.assertEquals(title_actual,title_expected);
    }
    @Test
    public void test2()
    {
        WebElement button=driver.findElement(By.cssSelector(".ui.black.button"));
        Assert.assertTrue(button.isDisplayed());
        Assert.assertEquals(button.getText(), "black");
    }
    @Test(enabled = false)
    public void test3()
    {
        System.out.println("This method is skipped");
    }

    @Test
    public void test4() throws SkipException
    {
        throw new SkipException("Skipping test case");
    }
    @AfterClass
    public void after()
    {
        driver.close();
    }
}
