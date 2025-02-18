@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:simulations
@SimulationPage
Feature: Simulation Feature
  This feature is having scenarios to test the simulation feature.

  Background:
    Given User hit the cbs app url "cbs.app.url".
    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin

  Scenario:Verify simulation page.
    When Verify user landed on the dashboard of the cbs web app.
    And User click on "Simulations" tab under menu on dashboard page.
    And Verify simulations page should display.
    And User click create simulations button on simulations page.

    And User select team for this bid as "Abhishek Mishra | abhishek.mishra@appinventiv.com | TokenAuthorizer" on team for this bid page.
    And User click on submit button on team for this bid page.
    And Verify user navigate to site profile page.
    And User enter name in simulation name text box on site profile page.
    And User enter name in prospective site name text box on site profile page.
    And User enter "CPU Hyderabad - 119A" in select reference site on site profile page.
    And User enter "Business" in sector txt box on site profile page.
    And User enter "Hybrid" in operating model text box on site profile page.
    And User enter "HYDERABAD" in city text box on site profile page.
    And User enter "P&L" in contract type on site profile page.
    And User enter "MG" in revenue assurance type on site profile page.
