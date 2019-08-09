Feature: Login into Application

Scenario Outline: Positive test validating login
  Given Initialized the driver with Firefox browser
  And User is on home page
  When User enters username <username> and password <password>
  And User clicks Login button
  Then User logs in
  And Browser windows close

Examples:
|username |password |
|test99@gmail.com |123456 |
|test1234@gmail.com|12345 |