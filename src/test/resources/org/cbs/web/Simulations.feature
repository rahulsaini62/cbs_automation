@allure.label.layer:WEB
@allure.label.owner:rahul.saini
@allure.label.page:/{org}/{cbs}/web
@allure.label.suite:Regression_Suite
@allure.label.subSuite:simulationsaaaaa
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

    And User select team for this bid as "sanjay.sahani@appinventiv.com" on team for this bid page.

    Then Verify building and cafe page should display.
    When User click create building button on building and cafe page.

    Then  Verify create building popup should display.
    And Verify ui of create building popup.
    When User random enter building name on create building popup.
    And User click submit button on create building popup.
    Then Verify "Created successfully" toast message should display.
    And Verify newly added building should display under building master on building and cafe page.
    And Verify newly added building should active status under building master on building and cafe page.

    When User click create cafe button on building and cafe page.
    Then  Verify create cafe popup should display.
    And Verify ui of create cafe popup.
    When User fill create cafe details and submit create cafe popup.
    Then Verify "Created successfully" toast message should display.

    And Verify newly added cafe should display under cafe master on building and cafe page.
    And Verify newly added cafe should active status under cafe master on building and cafe page.

    Then Verify building and cafe page should display.
    Then Verify events page should display.





