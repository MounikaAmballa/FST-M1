from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Title of the page: "+driver.title)

    print(driver.find_element(By.XPATH,"//h3[@id='third-header']").text)
    print(driver.find_element(By.XPATH,"//h5[text()='Fifth header']").value_of_css_property("color"))
    print(driver.find_element(By.XPATH,"//button[text()='Violet']").get_attribute("class"))
    print(driver.find_element(By.XPATH,"//button[text()='Grey']").text)
    driver.close()
