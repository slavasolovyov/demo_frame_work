@ECHO OFF 
:: This batch file details Windows 10, hardware, and networking configuration.
TITLE My test logger
ECHO Please wait... 
ECHO ============================
ECHO START TEST
ECHO ============================
cd c:\Users\vsolovyev\Projects\Test-frame\
mvn test
timeout 5
allure serve target/allure-results
timeout 5
PAUSE