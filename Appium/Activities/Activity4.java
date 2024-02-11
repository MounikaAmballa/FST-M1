package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4
{

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void addContact()
    {

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Create new contact']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Surname']")).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");


        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Save']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya Varma']")));

        String contact=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya Varma']")).getText();

        System.out.println(contact);

        Assert.assertEquals(contact, "Aaditya Varma");

    }

    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }

}
