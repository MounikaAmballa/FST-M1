from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title: " + driver.title)

    text=driver.find_element(By.ID,"input-text")
    print("Before: ",text.is_enabled())
    driver.find_element(By.ID,"toggleInput").click()
    print("After: ",text.is_enabled())
    driver.close()

