from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/dynamic-controls")

    print("Page title is: ", driver.title)

    wait = WebDriverWait(driver, 10)

    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    toggle = driver.find_element(By.ID, "toggleCheckbox")
    toggle.click()
    print("Checkbox hidden")
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    toggle.click()
    print("Checkbox visible")
    checkbox.click()
    print("Checkbox selected")
    driver.close()
