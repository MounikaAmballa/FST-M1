from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title: " + driver.title)

    username = driver.find_element(By.XPATH,"//input[contains(@class,'-username')]")
    username.send_keys("mounika")
    password = driver.find_element(By.XPATH,"//input[contains(@class,'-password')]")
    password.send_keys("abc@test")
    confirmpassword = driver.find_element(By.XPATH,"//label[text() = 'Confirm Password']/following-sibling::input")
    confirmpassword.send_keys("abc@test")
    email = driver.find_element(By.XPATH,"//input[@type='email']")
    email.send_keys("mounika@0503")
    driver.find_element(By.XPATH,"//button[contains(text(),'Sign Up')]").click()
    message = driver.find_element(By.ID,"action-confirmation")
    print("Signup message: " + message.text)
    driver.quit()



