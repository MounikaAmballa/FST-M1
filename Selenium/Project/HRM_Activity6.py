import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    wait = WebDriverWait(driver, 10)
    driver.get("http://alchemy.hguy.co/orangehrm")
    driver.find_element(By.ID,"txtUsername").send_keys("orange")
    driver.find_element(By.ID,"txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID,"btnLogin").click()
    time.sleep(2)

    #Verify Directory
    menuitem=driver.find_element(By.XPATH,"//div/ul/li[9]/a/b")
    if(menuitem.is_displayed()):
            menuitem.click()

    #Verify header
    header= driver.find_element(By.XPATH,"//div[@class='head']/h1")
    if(header.text=="Search Directory"):
        print("Text matches")
    else:
        print("Text doesn't match")

    driver.close()
