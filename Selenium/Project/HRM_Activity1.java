package Project;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_Activity1 {

    @Test
    public void testmethod()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        String title=driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM");
        driver.close();
    }

}
