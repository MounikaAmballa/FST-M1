from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title: " + driver.title)
    checkbox = driver.find_element(By.CSS_SELECTOR, "input.willDisappear")
    print("Before: ",checkbox.is_selected())
    checkbox.click()
    print("After: ",checkbox.is_selected())
    driver.close()


