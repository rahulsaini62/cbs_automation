@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:simulations
Feature: Role Master Feature
  This feature is having scenarios to test the CBS role master feature.

  Background:
    Given User hit the cbs app url "cbs.app.url".
    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin

  Scenario:Verify accessing Role Master Configuration and grid component.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "Simulations" tab under menu on dashboard page.
    And Verify simulations page should display.
    And User click create simulations button on simulations page.

    And User select team for this bid as "rahul.saini1@appinventiv.com" on team for this bid page.