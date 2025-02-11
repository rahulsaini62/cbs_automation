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
    Then Verify cbs master page should display.
    And Verify "Service Type Master" section should display on cbs master page.
    And Verify create service type button should display under service type master section on cbs master page.
    And Verify given column name should display under service type master section on cbs master page.




    When User click on create service type button on cbs master page.
    Then Verify create service type popup should display on cbs master page.
    And User enter below value in service type name and verify appropriate error messages under create service type popup on cbs master page.
      | serviceTypeName    | error | errorMessage              |
      | "    "             | yes   | Please enter Service Type |
#      | "   testing123   " | yes   | Please enter Service Type |
      | testing  234       | yes   | Please enter Service Type |
      | 1234testing        | no    | No Error Message          |
      | @#$%               | no    | No Error Message          |
      | t                  | no    | No Error Message          |
      | testing            | no    | No Error Message          |
    And User click on cancel button under create service type popup on cbs master page.

    When User click on create service type button on cbs master page.
    And User enter random service type name under create service type popup on cbs master page.
    And User click on submit button under create service type popup on cbs master page.

    And User make existing service type in "active" state on cbs master page.
    When User click on create service type button on cbs master page.
    And User enter existing service type name under create service type popup on cbs master page.
    And User click on submit button under create service type popup on cbs master page.
    And Verify service type error message as "Duplicate entry not allowed for Service Type Name." under create service type popup on cbs master page.



