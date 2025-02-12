package org.cbs.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.cbs.actions.CbsMasterActions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.cbs.manager.ParallelSession.getSession;

public class CbsMasterSteps {
    Faker faker = new Faker();

    private final CbsMasterActions cbsMasterActions;

    public CbsMasterSteps() {
        this.cbsMasterActions = new CbsMasterActions();
    }

    @Then("Verify cbs master page should display.")
    public void verifyCbsMasterPageShouldDisplay() {
        cbsMasterActions.verifyCbsMasterPageShouldDisplay();
    }

    @And("Verify {string} section should display on cbs master page.")
    public void verifySectionShouldDisplayOnCbsMasterPage(String titleName) {
        cbsMasterActions.verifyServiceTypeMasterSectionTitleShouldDisplay(titleName);
    }

    @And("User click on create service type button on cbs master page.")
    public void userClickOnCreateServiceTypeButtonOnCbsMasterPage() {
        cbsMasterActions.clickOnCreateServiceTypeBtn();
    }

    @Then("Verify create service type popup should display on cbs master page.")
    public void verifyCreateServiceTypePopupShouldDisplayOnCbsMasterPage() {
        cbsMasterActions.verifyCreateServiceTypePopupShouldDisplay();
    }

    @And("User click on cancel button under create service type popup on cbs master page.")
    public void userClickOnCancelButtonUnderCreateServiceTypePopupOnCbsMasterPage() {
        cbsMasterActions.clickOnCancelBtnOnCreateServiceTypePopup();
    }

    @And("User click on submit button under create service type popup on cbs master page.")
    public void userClickOnSubmitButtonUnderCreateServiceTypePopupOnCbsMasterPage() {
        cbsMasterActions.clickOnSubmitBtnOnCreateServiceTypePopup();
    }

    @And("User enter service type name as {string} under create service type popup on cbs master page.")
    public void userEnterServiceTypeNameAsUnderCreateServiceTypePopupOnCbsMasterPage(String serviceTypeName) {
        cbsMasterActions.enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(serviceTypeName);
    }

    @And("Verify create service type button should display under service type master section on cbs master page.")
    public void verifyCreateServiceTypeButtonShouldDisplayUnderServiceTypeMasterSectionOnCbsMasterPage() {
        cbsMasterActions.verifyCreateServiceTypeBtnShouldDisplay();
    }

    @And("Verify given column name should display under service type master section on cbs master page.")
    public void verifyGivenColumnNameShouldDisplayUnderServiceTypeMasterSectionOnCbsMasterPage() {
        cbsMasterActions.verifyGivenListOfColumnShouldDisplayCreateServiceTypePopup();
    }

    @And("User enter below value in service type name and verify appropriate error messages under create service type popup on cbs master page.")
    public void userEnterBelowValueInServiceTypeNameAndVerifyAppropriateErrorMessagesUnderCreateServiceTypePopupOnCbsMasterPage(DataTable dataTable) {
        List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> user : userList) {
            String serviceTypeName = user.get("serviceTypeName");
            String error = user.get("error");
            String errorMessage = user.get("errorMessage");

            cbsMasterActions.enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(serviceTypeName);
            if (error.equalsIgnoreCase("yes")) {
                cbsMasterActions.verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldDisplay(errorMessage);
            } else {
                cbsMasterActions.verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldNotDisplay();
                cbsMasterActions.verifySubmitBtnShouldEnabledOnCreateServiceTypePopup();
            }
        }

    }

    @And("User enter random service type name under create service type popup on cbs master page.")
    public void userEnterRandomServiceTypeNameUnderCreateServiceTypePopupOnCbsMasterPage() {
        getSession().getSharedData().put("serviceTypeName", faker.name().fullName());
        cbsMasterActions.enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(getSession().getSharedData().get("serviceTypeName").toString());
    }

    @And("User enter existing service type name under create service type popup on cbs master page.")
    public void userEnterExistingServiceTypeNameUnderCreateServiceTypePopupOnCbsMasterPage() {
        cbsMasterActions.enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(getSession().getSharedData().get("serviceTypeName").toString());
    }

    @And("Verify service type error message as {string} under create service type popup on cbs master page.")
    public void verifyServiceTypeErrorMessageAsUnderCreateServiceTypePopupOnCbsMasterPage(String errorMessage) {
        cbsMasterActions.verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldDisplay(errorMessage);
    }

    @And("User make existing service type in {string} state on cbs master page.")
    public void userMakeExistingServiceTypeInStateOnCbsMasterPage(String activeInactive) {
        if (activeInactive.equalsIgnoreCase("active")){
           // condition=true;
        }
    }

    @Then("Verify Role Master Configuration is visible on cbs master page.")
    public void verifyRoleMasterConfigurationIsVisibleOnCbsMasterPage() {
        cbsMasterActions.verifyRoleMasterConfigurationVisibility();

    }

    @And("User click on create role button on cbs master page.")
    public void userClickOnCreateRoleButtonOnCbsMasterPage() {
    }

    @Then("Verify role master create popup should get open on cbs master page.")
    public void verifyRoleMasterCreatePopupShouldGetOpenOnCbsMasterPage() {
    }
}
