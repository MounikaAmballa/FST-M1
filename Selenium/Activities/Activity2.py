from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/login-form")

    print("Page title is: ", driver.title)

    username = driver.find_element(By.ID, "username").send_keys("admin")

    password = driver.find_element(By.ID, "password").send_keys("password")

    submit = driver.find_element(By.CSS_SELECTOR, "button.button:nth-child(4)")
    submit.click()

    print("Message: "+driver.find_element(By.ID, "action-confirmation").text)

    driver.close()