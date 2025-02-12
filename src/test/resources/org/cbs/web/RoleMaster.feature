@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:cbs
@RoleMaster
Feature: Role Master Feature
  This feature is having scenarios to test the CBS role master feature.

  Background:
    Given User hit the cbs app url "cbs.app.url".
    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin

  @TC-RM-01
  Scenario:Verify accessing Role Master Configuration and grid component.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    Then Verify Role Master Configuration is visible on cbs master page.

  @TC-RM-02
  Scenario:Check if user click on CTA - Create Role.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    Then Verify role master create popup should get open on cbs master page.



