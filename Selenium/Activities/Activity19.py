from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")


    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Title: " + driver.title)
    # OK
    driver.find_element(By.ID,"confirm").click()
    alert=driver.switch_to.alert
    print("Text in alert box: "+alert.text)
    alert.accept()
    # Cancel
    driver.find_element(By.ID,"confirm").click()
    alert1=driver.switch_to.alert
    alert1.dismiss()
    driver.quit()
