from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title: " + driver.title)

    dropdown=driver.find_element(By.ID,"single-select")
    option=Select(dropdown)
    option.select_by_visible_text("Option 2")
    print("selection by visible text: ",option.first_selected_option.text)
    option.select_by_index(3)
    print("selection by Index: ",option.first_selected_option.text)
    option.select_by_value("4")
    print("selection by Value: ",option.first_selected_option.text)
    print("All options in the List:")
    options=option.options
    for ele in options:
        print(ele.text)
    driver.quit()

