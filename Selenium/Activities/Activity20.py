from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Title: " + driver.title)

    driver.find_element(By.ID,"prompt").click()
    alert=driver.switch_to.alert
    print("Text on alert box: ",alert.text)
    alert.send_keys("Awesome!")
    alert.accept()
    driver.quit()








