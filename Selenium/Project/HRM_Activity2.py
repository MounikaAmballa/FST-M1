from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("http://alchemy.hguy.co/orangehrm")
    header = driver.find_element(By.TAG_NAME,"img").get_attribute("src")
    print("Header URL: ",header)
    driver.quit()

