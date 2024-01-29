package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HRM_Activity5 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        //Click on MyInfo
        driver.findElement(By.xpath("//div/ul/li[6]/a/b")).click();

        driver.findElement(By.xpath("//input[@value='Edit']")).click();

        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Charvik");

        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Kalyan");

        driver.findElement(By.id("personal_optGender_1")).click();

        WebElement dropdown=driver.findElement(By.id("personal_cmbNation"));
        Select select=new Select(dropdown);
        select.getFirstSelectedOption();

        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("2023-05-31");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save']")));

        driver.findElement(By.xpath("//input[@value='Save']")).click();

        driver.close();

    }
}