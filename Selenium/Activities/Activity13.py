from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title: " + driver.title)

    rows=driver.find_elements(By.XPATH,"//table[contains(@class,'striped')]/tbody/tr")
    print("Number of rows: ",len(rows))
    cols=driver.find_elements(By.XPATH,"//table[contains(@class,'striped')]/tbody/tr[1]/td")
    print("Number of rows: ",len(cols))
    cell_3rdrow=driver.find_elements(By.XPATH,"//table[contains(@class,'striped')]/tbody/tr[3]/td")
    print("Values in 3rd row")
    for row in cell_3rdrow:
        print("Value in 3rd row: ", row.text)
    cellValue = driver.find_element(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    print("Second row and second cell value: " , cellValue.text)
    driver.close()




