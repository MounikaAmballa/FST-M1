package Project;

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

public class Activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        wait=new WebDriverWait(driver, Duration.ofSeconds(5));


    }

    @Test
    public void googleTask()
    {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Google Tasks");

        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(AppiumBy.accessibilityId("Create new task"))));

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Google Keep");

        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(AppiumBy.accessibilityId("Create new task"))));

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Task 3");

        driver.findElement(AppiumBy.id("add_task_done")).click();

        String list=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']")).getText();

       Assert.assertTrue(list.equals("Google Tasks") || list.equals("Google Keep") || list.equals("Task 3"));

    }

    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }
}
