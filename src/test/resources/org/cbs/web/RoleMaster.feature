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