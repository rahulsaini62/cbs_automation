#@allure.label.layer:WEB
#@allure.label.owner:rahul.saini
#@allure.label.page:/{org}/{cbs}/web
#@allure.label.suite:Regression_Suite
#@allure.label.subSuite:service_type_master
#Feature: Service Type Master Feature
#  This feature is having scenarios to test the CBS Service Type Master feature.
#
#  Background:
#    Given User hit the cbs app url "cbs.app.url".
#    And User login with username as "cbs.username" and password as "cbs.password" on cbs admin
#    And User is on cbs master page.
#
#  @TC-STM-01 @TC-STM-02 @#TC-STM-03 @#TC-STM-04
#  Scenario: Verify valid login on CBS portal.
##    TC-STM-12
##    Then Verify loader display during data fetching on cbs master page.
#    When Verify cbs master page should display.
#    #TC-STM-01
#    And Verify "Service Type Master" section should display on cbs master page.
#    And Verify create service type button should display under service type master section on cbs master page.
#    And Verify given column name should display under service type master section on cbs master page.
#
#    When User click on create service type button on cbs master page.
#    Then Verify create service type popup should display on cbs master page.
#
#    #TC-STM-02
#    And Verify UI of create service type popup.
#
#    #TC-STM-03 #TC-STM-04
#    And User enter below value in service type name and verify appropriate error messages under create service type popup on cbs master page.
#      | serviceTypeName                                                                                                                                                                                           | error | errorMessage                                       |
#      | "    "                                                                                                                                                                                                    | yes   | Please enter Service Type                          |
##      | "   testing123   " | yes   | Please enter Service Type |
#      | testing  234                                                                                                                                                                                              | yes   | Service Type should not contain consecutive spaces |
#      | itezeijuuecevpuiautpuadmziqodujwdilikdglbzkxmjngzilrjfyiwsqsarrfridvrmmsrpulaijjwpivkwlbkosizehbznxhcrgjioybimgijbcnduufxabtzxwredtvhihhkithscjfiiyvbptvwgpdgxpqvrhqauywcqcywgijwihzlmvynlhoilluooklbcahp | yes   | Max limit exceeded for Service Type                |
#      | 1234testing                                                                                                                                                                                               | no    | No Error Message                                   |
#      | test@#$%                                                                                                                                                                                                  | no    | No Error Message                                   |
#      | t                                                                                                                                                                                                         | no    | No Error Message                                   |
#      | "   testing"                                                                                                                                                                                              | no    | No Error Message                                   |
#    And User enter random service type name under create service type popup on cbs master page.
#    And User click on submit button under create service type popup on cbs master page.
##    TC-STM-07
#    Then Verify "Created successfully" toast message should display.
#    Then Verify cbs master page should display.
#    And Verify newly created service type should display under service type master section on cbs master page.
#
##    And User make existing service type as "active" state on cbs master page.
#    When User click on create service type button on cbs master page.
#    And User enter existing service type name under create service type popup on cbs master page.
#    And User click on submit button under create service type popup on cbs master page.
##    TC-STM-05
#    And Verify service type error message as "Duplicate entry not allowed for Service Type Name." under create service type popup on cbs master page.
#
#    When User enter random service type name under create service type popup on cbs master page.
#    And User click on cancel button under create service type popup on cbs master page.
##    TC-STM-09
#    Then Verify discard changes popup ui.
#
##    TC-STM-10
#    When User click cancel button on discard changes popup.
#    Then Verify create service type popup should display on cbs master page.
##    And Verify service type should be prefilled on create service type popup.     // value missing on HTML
#    When User click on cancel button under create service type popup on cbs master page.
#    And User click proceed button on discard changes popup.
#    When Verify discard changes popup should not display.
#    And Verify cbs master page should display.
##  TC-STM-13
##    Then Verify pressing enter on a CTA simulates a mouse click event.
##    And Verify pressing esc on a popup simulates clicking cancel.