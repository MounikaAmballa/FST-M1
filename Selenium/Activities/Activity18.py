from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title: " + driver.title)
    dropdown=driver.find_element(By.ID,"multi-select")
    select=Select(dropdown)
    select.select_by_visible_text("Javascript")
    select.select_by_index(4)
    select.select_by_index(5)
    select.select_by_index(6)
    select.select_by_value("node")
    select.deselect_by_index(5)
    driver.quit()