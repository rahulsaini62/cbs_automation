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

  @TC-RM-03 @TC-RM-04
  Scenario: Validate the input for Role Name with invalid role name.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    And Verify role master create popup should get open on cbs master page.
    Then User enter below value in role name and verify appropriate error messages under create role popup on cbs master page.
      | roleName                  | error | errorMessage                                       |
      | "    "                    | yes   | Please enter Role Name                             |
      | testing  234              | yes   | Role Name should not contain consecutive spaces    |
      | <maxCharacterLimitExceed> | yes   | Max limit exceeded for Role Name                   |
      | 1234testing               | no    | No Error Message                                   |
      | test@#$%                  | no    | No Error Message                                   |
      | t                         | no    | No Error Message                                   |
      | "   testing"              | no    | No Error Message                                   |

  @TC-RM-05
  Scenario: Check error message for duplicate role name.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    And Verify role master create popup should get open on cbs master page.
    And User enter existing role name in role name txt box on cbs master page.
    And User click on submit button under create role name popup on cbs master page.
    Then Verify error message for duplicate role name should display on cbs master page.

  @TC-RM-O7
  Scenario: Verify successful submission of data for create role.
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    And Verify role master create popup should get open on cbs master page.
    And User enter valid role name in role name txt box on cbs master page.
    And User click on submit button under create role name popup on cbs master page.
    Then Verify success toaster message display on cbs master page.
    And Verify same entry should shown in cbs role table on cbs master page.

  @TC_RM_09
  Scenario: Check confirmation popup on cancellation after modifying some data
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    And Verify role master create popup should get open on cbs master page.
    And User enter value in role name txt box on cbs master page.
    And User click cancel button under create role master popup on cbs master page.
    Then Verify confirmation popup on cancellation after modifying some data on cbs master page.

  @TC_RM_10
  Scenario: Verify cancellation action on discard popup create role master .
    When Verify user landed on the dashboard of the cbs web app.
    And Verify simulations page should display.
    And User click on "CBS Masters" tab under menu on dashboard page.
    And Verify cbs master page should display.
    And User click on create role button on cbs master page.
    And Verify role master create popup should get open on cbs master page.
    And User enter value in role name txt box on cbs master page.
    And User click cancel button under create role master popup on cbs master page.
    And User click cancel button on discard changes popup.
    Then Verify role master create popup should get open on cbs master page.
    And User click cancel button under create role master popup on cbs master page.
    And User click proceed button on discard changes popup.
    And Verify discard changes popup should not display.
    Then Verify cbs master page should display.





