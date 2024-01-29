package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HRM_Activity4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        //click on PIM
        driver.findElement(By.xpath("//div/ul/li[2]/a/b")).click();

        //click on Add Employee button
        driver.findElement(By.id("btnAdd")).click();
        //Fill all the required fields
        WebElement fname=driver.findElement(By.name("firstName"));
        WebElement lname=driver.findElement(By.name("lastName"));
        fname.sendKeys("Mounika");
        lname.sendKeys("Amballa");
        driver.findElement(By.id("btnSave")).click();
        // check name in the Employee List
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Mounika Amballa");

        driver.findElement(By.xpath("//div[@class='ac_results']//ul//li[1]//strong")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBtn']")));
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[3]")));

        // verify employee creation
        WebElement result=driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        if(result.getText().contains("Mounika"))
        {
            System.out.println("Employee created");
        }
        else {
            System.out.println("Employee not created");

        }

        driver.close();

    }

}
