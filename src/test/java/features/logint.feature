Feature: Login Check

  Scenario Outline: Positive check:
    Given I as a user open navigate to url "<URL>" using browser "<Browser>"
    When I enter the name as "<loginName>" and password as "<password>"
    And I press submit button
    Then I have to see text: "<text>"

    Examples:
    |Browser|URL                                     |loginName|password|text      |
    |chrome |http://testing-ground.scraping.pro/login|admin    |12345   |WELCOME :)|
