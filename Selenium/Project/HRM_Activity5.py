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

    #click on MyInfo
    driver.find_element(By.XPATH,"//div/ul/li[6]/a/b").click()

    driver.find_element(By.XPATH,"//input[@value='Edit']").click()

    driver.find_element(By.ID,"personal_txtEmpFirstName").clear()
    driver.find_element(By.ID,"personal_txtEmpFirstName").send_keys("Charvik")

    driver.find_element(By.ID,"personal_txtEmpLastName").clear()
    driver.find_element(By.ID,"personal_txtEmpLastName").send_keys("Kalyan")

    driver.find_element(By.ID,"personal_optGender_1").click()

    dropdown=driver.find_element(By.ID,"personal_cmbNation")
    select=Select(dropdown)
    select.first_selected_option

    driver.find_element(By.ID,"personal_DOB").clear()
    driver.find_element(By.ID,"personal_DOB").send_keys("2023-05-31")

    wait.until(expected_conditions.element_to_be_clickable((By.XPATH,"//input[@value='Save']")))

    driver.find_element(By.XPATH,"//input[@value='Save']").click()

    driver.close()
