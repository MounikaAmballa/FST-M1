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

    #click on My Info
    driver.find_element(By.XPATH,"//div/ul/li[6]/a/b").click()

    #click on Emergency Contacts
    driver.find_element(By.XPATH,"//ul[@id='sidenav']/li[3]").click()
    #Get emergency contacts
    cell= driver.find_elements(By.XPATH,"//table[@id='emgcontact_list']/tbody/tr/td[5]")

    for cell1 in cell:
        print(cell1.text)

    driver.close()
