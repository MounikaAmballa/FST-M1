package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException  {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
    }


    @Test
    public void multiplyTest()
    {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_6")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        // Assertion
        Assert.assertEquals(result, "30");
    }



    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }
}
