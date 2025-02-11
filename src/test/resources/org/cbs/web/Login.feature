@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:cbs
@home
Feature: Login Feature
  This feature is having scenarios to test the CBS login feature.

  Background:
    Given User hit the cbs app url "cbs.app.url".
    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin

  @TC_M1_01
  Scenario: Verify valid login on CBS portal.
#    Then   Wait for the cbs page loader.
    And  Verify user landed on the dashboard of the cbs web app.

    And Verify simulations page should display.

    And User click on "cbs master" tab under "admin" tab under menu on dashboard page.
#    Then Verify cbs master page should display.



