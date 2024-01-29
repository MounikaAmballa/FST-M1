from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Title: ",driver.title)
    if driver.title == "OrangeHRM":
        print("Title of the Website matches")
    else:
        print("Title doesn't match")
    driver.quit()

