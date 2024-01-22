from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title of the page: "+driver.title)

    action=ActionChains(driver)

    #left click
    action.click().perform()
    frontText = driver.find_element(By.CLASS_NAME,"active").text
    print("left click: "+frontText)

    #double click
    action.double_click().perform()
    frontText = driver.find_element(By.CLASS_NAME,"active").text
    print("double click: "+frontText)

    #right click
    action.context_click().perform()
    frontText = driver.find_element(By.CLASS_NAME,"active").text
    print("right click: "+frontText)
    driver.close()



