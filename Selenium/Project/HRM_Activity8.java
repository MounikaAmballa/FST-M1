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


public class HRM_Activity8 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        //click on Dashboard
        driver.findElement(By.xpath("//div/ul/li[8]/a/b")).click();
        //click on Apply Leave
        driver.findElement(By.xpath("//table/tbody/tr/td[4]/div/a/span")).click();

        WebElement dropdown= driver.findElement(By.id("applyleave_txtLeaveType"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("DayOff");

        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-01-30");

        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-01-31");

        driver.findElement(By.xpath("//input[@value='Apply']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'My Leave')]")));
        driver.findElement(By.xpath("//a[contains(text(),'My Leave')]")).click();

        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2024-01-30");

        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys("2024-01-31");

        driver.findElement(By.name("btnSearch")).click();


        WebElement leave_status=driver.findElement(By.xpath("//div[@id='tableWrapper']/table/tbody/tr/td[6]"));
        System.out.println("Leave Status: "+leave_status.getText());

        driver.close();

    }
}
