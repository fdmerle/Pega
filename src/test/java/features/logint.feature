Feature: Login Check

  Scenario Outline: Check:
    Given I as a user open navigate to url "<URL>" using browser "<Browser>"
    When I enter the name as "<loginName>" and password as "<password>"
    And I press submit button
    Then I have to see text: "<text>"

    Examples:
      | Browser | URL                                      | loginName                                          | password                         | text           |
      | Chrome  | http://testing-ground.scraping.pro/login | admin                                              | 12345                            | WELCOME :)     |
      | Chrome  | http://testing-ground.scraping.pro/login | $%^@                                               | #$%#$$%                          | ACCESS DENIED! |
      | Chrome  | http://testing-ground.scraping.pro/login | Admin                                              | 12345                      | ACCESS DENIED! |
      | Chrome  | http://testing-ground.scraping.pro/login | <img onerror ='alert(1)' Src='X'                   | <img onerror ='alert(1)' Src='X' | ACCESS DENIED! |
      | Chrome  | http://testing-ground.scraping.pro/login | verrylongstringggggggggggggggggggggggggggggggggggg | verylongpasswordddddddddddddddd  | ACCESS DENIED! |