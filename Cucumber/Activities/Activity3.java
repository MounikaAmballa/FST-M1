package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void User_is_on_the_page()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void simpleAlert()
    {
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void confirmAlert()
    {
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void promptAlert()
    {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void openAlert()
    {
        alert=driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readText()
    {
        System.out.println("Alert message: "+alert.getText());
    }

    @And("^Write a custom message in it$")
    public void customMessage()
    {
        alert.sendKeys("prompt message");
    }

    @And("^Close the alert$")
    public void closeAlert()
    {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void cancelAlert()
    {
        alert.dismiss();
    }

    @And("^Read the result text$")
    public void resultText()
    {
        System.out.println("result");
    }

    @And("^Close Browser$")
    public void closeBrowser()
    {

        driver.close();
    }


}
