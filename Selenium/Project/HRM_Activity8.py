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

    #click on Dashboard
    driver.find_element(By.XPATH,"//div/ul/li[8]/a/b").click()
    #click on Apply Leave
    driver.find_element(By.XPATH,"//table/tbody/tr/td[4]/div/a/span").click()

    dropdown= driver.find_element(By.ID,"applyleave_txtLeaveType")
    select=Select(dropdown)
    select.select_by_visible_text("DayOff")

    driver.find_element(By.ID,"applyleave_txtFromDate").clear()
    driver.find_element(By.ID,"applyleave_txtFromDate").send_keys("2024-01-30")

    driver.find_element(By.ID,"applyleave_txtToDate").clear()
    driver.find_element(By.ID,"applyleave_txtToDate").send_keys("2024-01-31")

    driver.find_element(By.XPATH,"//input[@value='Apply']").click()

    wait.until(expected_conditions.element_to_be_clickable((By.XPATH,"//a[contains(text(),'My Leave')]")))
    driver.find_element(By.XPATH,"//a[contains(text(),'My Leave')]").click()

    driver.find_element(By.ID,"calFromDate").clear()
    driver.find_element(By.ID,"calFromDate").send_keys("2024-01-30")

    driver.find_element(By.ID,"calToDate").clear()
    driver.find_element(By.ID,"calToDate").send_keys("2024-01-31")

    driver.find_element(By.NAME,"btnSearch").click()

    leave_status=driver.find_element(By.XPATH,"//div[@id='tableWrapper']/table/tbody/tr/td[6]")
    print("Leave Status: "+leave_status.text)

    driver.close()
