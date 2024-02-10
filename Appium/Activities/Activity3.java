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

public class Activity3 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

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
    public void addTest()
    {
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();


        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Addition result: "+result);

        // Assertion
        Assert.assertEquals(result, "9");
    }

    // Test method
    @Test
    public void subtractionTest()
    {
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();


        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Subtraction result: "+result);


        // Assertion
        Assert.assertEquals(result, "10");
    }


    @Test
    public void multiplicationTest()
    {
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_6")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();


        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Multiplication result: "+result);

        // Assertion
        Assert.assertEquals(result, "12");
    }

    @Test
    public void divisionTest()
    {
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Division result: "+result);

        // Assertion
        Assert.assertEquals(result, "2");
    }


    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }
}