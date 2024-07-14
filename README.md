## General info
This project is autotest project for testing [7745.by](https://7745.by/) site.
	
## Technologies
Project is created with:
* java version: 17
* selenium version: 4.19.1
* rest-assured version: 5.4.0
* allure version: 2.24.0
* aspectj version: 1.9.22
* testng version: 7.10.1
	
## Contents
The project includes:
* # main 
  * utils
    * DriverFactory
    * ScreenshotUtil
    * MyWaitor 
  * pages
    * HomePage
    * CatalogPage
    * CartPage
    * ProductPage
    * LoginForm
    * RegistrationForm 
  * retry
    * RetryAnalyzer
    * AnnotationTransformer
  * resources
    * log4j2.properties 
  * listeners
    * TestListener 
* # test
  * uiTest
    * BaseTest
    * UITest
  * apiTest
    * BaseAPITest
    * APITest
  * resources
    * json
      * jsonchema
    * testsuites
      * APItestSuite
      * UItestSuite
   * allure.properties
 
* # pom.xml

 ## Author
 This project made by Yuliya Lavrova
