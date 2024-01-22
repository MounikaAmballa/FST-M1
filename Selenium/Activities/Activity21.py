from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:

    driver.get("https://v1.training-support.net/selenium/tab-opener")
    print("Page title is: ", driver.title)
    wait = WebDriverWait(driver, 10)

    driver.find_element(By.TAG_NAME,"a").click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("Number of handles: ",driver.window_handles)
    for handle in driver.window_handles:
        driver.switch_to.window(handle)

    #wait.until(expected_conditions.number_of_windows_to_be(2))
    print("Newly opened tab: ",driver.window_handles)
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("Page title is: ", driver.title)
    heading=driver.find_element(By.XPATH,"//div[@class='content']")
    print(heading.text)

    driver.find_element(By.ID,"actionButton").click()

    wait.until(expected_conditions.number_of_windows_to_be(3))
    #Switch focus
    for handle1 in driver.window_handles:
        driver.switch_to.window(handle1)

    wait.until(expected_conditions.number_of_windows_to_be(3))
    print("Current tab: ", driver.current_window_handle)
    print("Page title: ", driver.title)
    print(driver.find_element(By.CLASS_NAME,"content").text)
    driver.quit()
