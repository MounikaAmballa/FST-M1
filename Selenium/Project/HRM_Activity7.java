package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HRM_Activity7 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        // CLick on My Info
        driver.findElement(By.xpath("//div/ul/li[6]/a/b")).click();

        driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience")));
        driver.findElement(By.id("addWorkExperience")).click();

        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");

        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2016-02-29");

        driver.findElement(By.id("experience_to_date")).clear();
        driver.findElement(By.id("experience_to_date")).sendKeys("2020-05-15");

        driver.findElement(By.id("experience_comments")).sendKeys("Added Experience details");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnWorkExpSave")));
        driver.findElement(By.id("btnWorkExpSave")).click();

        driver.close();

    }
}
