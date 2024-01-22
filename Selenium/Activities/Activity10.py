from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)
    checkbox=driver.find_element(By.NAME,"toggled")
    print("Before: ",checkbox.is_displayed())
    driver.find_element(By.ID,"toggleCheckbox").click()
    print("After: ",checkbox.is_displayed())
    driver.close()




