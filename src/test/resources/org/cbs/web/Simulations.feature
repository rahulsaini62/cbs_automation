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
#    When Verify user landed on the dashboard of the cbs web app.
    And User click on "Simulations" tab under menu on dashboard page.
    And Verify simulations page should display.
    And User click create simulations button on simulations page.

    And User select team for this bid as "Abhishek Mishra | abhishek.mishra@appinventiv.com | TokenAuthorizer" on team for this bid page.
    And User click on submit button on team for this bid page.

    Then Verify "Created Successfully" toast message should display on site profile page.

    And Verify user navigate to site profile page.
    And User enter name in simulation name text box on site profile page.
    And User enter name in prospective site name text box on site profile page.
    And User enter "CPU Hyderabad - 119A" in select reference site on site profile page.
    And User enter "Business" in sector txt box on site profile page.
    And User enter "Hybrid" in operating model text box on site profile page.
    And User enter "HYDERABAD" in city text box on site profile page.
    And User enter "P&L" in contract type on site profile page.
    And User select "24" in bid submission date on site profile page.
    And User select "15" in estimated mobilization date on site profile page.
    And User enter "2.00" in  gas cost txt box on site profile page.
    And User enter "10.00" in year on year txt box on site profile page.
    And User enter "4 Year" in contract duration year text box on site profile page.
    And User enter "MG" in revenue assurance type on site profile page.
    And User click on save section data btn on site profile page.

    Then Verify "Created successfully" toast message should display.
    #And User click on validate apl btn on site profile page.
    And User click on building & cafe btn on site profile page.

    Then Verify building and cafe page should display.
    When User click create building button on building and cafe page.

    Then  Verify create building popup should display.
    And Verify ui of create building popup.
    When User random enter building name on create building popup.
    And User click submit button on create building popup.
    Then Verify "Created successfully" toast message should display.
    And Verify newly added building should display under building master on building and cafe page.
#    And Verify newly added building should active status under building master on building and cafe page.

    When User click create cafe button on building and cafe page.
    Then  Verify create cafe popup should display.
    And Verify ui of create cafe popup.
    When User fill create cafe details and submit create cafe popup.
  #  Then Verify "Created successfully" toast message should display.

    And Verify newly added cafe should display under cafe master on building and cafe page.
#    And Verify newly added cafe should active status under cafe master on building and cafe page.
    And User clicks on events button.
    Then Verify events page should display.
    And User enter "20.00" in event revenue index two text box on events page.
    And User enter "30.00" in food cost index tow text box on events page.
    And User click copy full term button on events page.

    And Verify after click on copy to full team same value should reflect in each column on events page.
    Then User click on save section data btn on events page.
