from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title: " + driver.title)

    rows=driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tbody/tr")
    print("Number of rows: ",len(rows))
    cols=driver.find_elements(By.XPATH,"//table[@id='sortableTable']/thead/tr/th")
    print("Number of cols: ",len(cols))
    cellvalue=driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print(cellvalue.text)
    driver.find_element(By.XPATH,"//table[@id='sortableTable']/thead/tr/th").click()
    cellvalue_sort=driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print("After sort:"+cellvalue_sort.text)
    footer = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tfoot/tr/th")
    print("Cell values of the footer: ")
    for foot in footer:
        print(foot.text)

    driver.close()



