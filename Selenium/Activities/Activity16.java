package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title: " + driver.getTitle());
        WebElement username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        username.sendKeys("mounika");
        WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        password.sendKeys("abc@test");
        WebElement confirmpassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        confirmpassword.sendKeys("abc@test");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("mounika@0503");
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        WebElement message = driver.findElement(By.id("action-confirmation"));
        System.out.println("Signup message: " + message.getText());
        driver.quit();

    }
    }
