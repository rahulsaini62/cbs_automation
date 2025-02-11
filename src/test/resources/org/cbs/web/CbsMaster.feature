@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:cbs
@service_type_master
Feature: Login Feature
  This feature is having scenarios to test the CBS login feature.

  Background:
    Given User hit the cbs app url "cbs.app.url".
    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin

  @TC-STM-01
  Scenario: Verify valid login on CBS portal.
    And  Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And Verify "Service Type Master" section should display on cbs master page.

    And Verify "Role Master" section should display on cbs master page.
    And User click on create service type button on cbs master page.
    Then Verify create service type popup should display on cbs master page.

    And User click on cancel button under create service type popup on cbs master page.
    And User click on submit button under create service type popup on cbs master page.


