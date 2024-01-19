package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title: "+driver.getTitle());

        WebElement dropdown=driver.findElement(By.id("single-select"));
        Select option=new Select(dropdown);
        option.selectByVisibleText("Option 2");
        System.out.println("selection by visible text: "+option.getFirstSelectedOption().getText());
        option.selectByIndex(3);
        System.out.println("selection by Index: "+option.getFirstSelectedOption().getText());
        option.selectByValue("4");
        System.out.println("selection by Value: "+option.getFirstSelectedOption().getText());
        System.out.println("All options in the List:");
        List<WebElement> options=option.getOptions();
        for(WebElement ele:options) {
            System.out.println(ele.getText());
        }
        driver.quit();
    }
}
