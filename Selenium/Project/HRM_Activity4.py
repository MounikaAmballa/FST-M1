import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
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

    #click on PIM
    driver.find_element(By.XPATH,"//div/ul/li[2]/a/b").click()

    #click on Add Employee button
    time.sleep(2)
    driver.find_element(By.ID,"btnAdd").click()

    #Fill all the required fields
    fname=driver.find_element(By.NAME,"firstName")
    lname=driver.find_element(By.NAME,"lastName")
    fname.send_keys("Mounika")
    lname.send_keys("Amballa")
    driver.find_element(By.ID,"btnSave").click()

    #check name in the Employee List
    driver.find_element(By.ID,"menu_pim_viewEmployeeList").click()
    time.sleep(2)

    driver.find_element(By.ID,"empsearch_employee_name_empName").send_keys("Mounika Amballa")

    wait.until(expected_conditions.element_to_be_clickable((By.XPATH,"//div[@class='ac_results']//ul//li[1]//strong")))

    driver.find_element(By.XPATH,"//div[@class='ac_results']//ul//li[1]//strong").click()

    driver.find_element(By.XPATH,"//input[@id='searchBtn']").click()

    wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//tbody/tr[1]/td[3]")))

    # verify employee creation
    result=driver.find_element(By.XPATH,"//tbody/tr[1]/td[3]")

    if(result.text=="Mounika"):
        print("employee created")
    else:
        print("employee not created")

    driver.close()










