Pega task
=================

There is a test that verify the login process to http://testing-ground.scraping.pro/login

Framework builded with usage of Selenium 2.53 and Cucumber

Supporting browsers: Chrome, Firefox (version not higher then 46)

Prerequisites
-------------

In order to run browser tests, Selenium will need to be able to drive a browser installed to your system.

Clone the repo:
-------------

Git:

$ git clone git@github.com:mdmerle/Pega.git

Or

refer to https://github.com/mdmerle/Pega 

Run test
-------------

mvn clean verify

Or

via IDE: src/test/java/features/login.feature

via IDE: src/test/java/test_runner/TestRunner



