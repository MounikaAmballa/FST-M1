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

    # CLick on My Info
    driver.find_element(By.XPATH,"//div/ul/li[6]/a/b").click()

    driver.find_element(By.XPATH,"//ul[@id='sidenav']//a[contains(text(),'Qualifications')]").click()

    wait.until(expected_conditions.element_to_be_clickable((By.ID,"addWorkExperience")))
    driver.find_element(By.ID,"addWorkExperience").click()

    driver.find_element(By.ID,"experience_employer").send_keys("IBM")
    driver.find_element(By.ID,"experience_jobtitle").send_keys("Test Specialist")

    driver.find_element(By.ID,"experience_from_date").clear()
    driver.find_element(By.ID,"experience_from_date").send_keys("2016-02-29")

    driver.find_element(By.ID,"experience_to_date").clear()
    driver.find_element(By.ID,"experience_to_date").send_keys("2020-05-15")

    driver.find_element(By.ID,"experience_comments").send_keys("Added Experience details")

    wait.until(expected_conditions.element_to_be_clickable((By.ID,"btnWorkExpSave")))
    driver.find_element(By.ID,"btnWorkExpSave").click()

    driver.close()
