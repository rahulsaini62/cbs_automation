package org.cbs.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.cbs.actions.CbsMasterActions;
import org.cbs.actions.SharedActions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.data.DataReader.loadCbsMasterProps;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.junit.Assert.assertEquals;

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

    @Then("Verify create service type popup should not display on cbs master page.")
    public void verifyCreateServiceTypePopupShouldNotDisplayOnCbsMasterPage() {
        cbsMasterActions.verifyCreateServiceTypePopupShouldNotDisplay();
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
            String serviceTypeName = user.get("serviceTypeName").replaceAll("\"", "");
            String error = user.get("error");
            String errorMessage = user.get("errorMessage");

            cbsMasterActions.enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(serviceTypeName);
            if (error.equalsIgnoreCase("yes")) {
                cbsMasterActions.verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldDisplay(errorMessage);
            } else {
                cbsMasterActions.verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldNotDisplay();
                cbsMasterActions.verifySubmitBtnShouldEnabledOnCreateServiceTypePopup();
            }
            cbsMasterActions.clearServiceTypeNameTxtBxOnCreateServiceTypePopup();
        }

    }

    @And("User enter random service type name under create service type popup on cbs master page.")
    public void userEnterRandomServiceTypeNameUnderCreateServiceTypePopupOnCbsMasterPage() {
        getSession().getSharedData().put("serviceTypeName", faker.lorem().characters(20));
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

    @And("User make existing service type as {string} state on cbs master page.")
    public void userMakeExistingServiceTypeAsStateOnCbsMasterPage(String activeInactive) {
        if (activeInactive.equalsIgnoreCase("active")) {
            cbsMasterActions.activeInactiveGivenServiceTypeStatus(getSession().getSharedData().get("serviceTypeName").toString(), true);
        } else {
            cbsMasterActions.activeInactiveGivenServiceTypeStatus(getSession().getSharedData().get("serviceTypeName").toString(), false);
        }
    }

    @Then("Verify Role Master Configuration is visible on cbs master page.")
    public void verifyRoleMasterConfigurationIsVisibleOnCbsMasterPage() {
        cbsMasterActions.verifyRoleMasterConfigurationVisibility();

    }

    @And("User click on create role button on cbs master page.")
    public void userClickOnCreateRoleButtonOnCbsMasterPage() {
        cbsMasterActions.clickCreateRoleButton();
    }

    @Then("Verify role master create popup should get open on cbs master page.")
    public void verifyRoleMasterCreatePopupShouldGetOpenOnCbsMasterPage() {
        cbsMasterActions.verifyCreateRolePopupVisibility();
    }

    @And("Verify UI of create service type popup.")
    public void verifyUIOfCreateServiceTypePopup() {
        cbsMasterActions.verifyServiceTypeNameFieldShouldDisplayOnCreateServiceTypePopup();
        cbsMasterActions.verifyCancelBtnShouldDisplayOnCreateServiceTypePopup();
        cbsMasterActions.verifyCancelBtnShouldEnabledDisplayOnCreateServiceTypePopup();
        cbsMasterActions.verifySubmitBtnShouldDisplayOnCreateServiceTypePopup();
        cbsMasterActions.verifySubmitBtnShouldDisabledOnCreateServiceTypePopup();

    }

    @Then("Verify {string} toast message should display.")
    public void verifyToastMessageShouldDisplay(String expectedToastMessage) {
        cbsMasterActions.verifyGivenToastMessageShouldDisplay(expectedToastMessage);
    }

    @And("User click cancel button on discard changes popup.")
    public void userClickCancelButtonOnDiscardChangesPopup() {
        cbsMasterActions.clickOnCancelBtnOnDiscardChangesPopup();
    }

    @And("User click proceed button on discard changes popup.")
    public void userClickProceedButtonOnDiscardChangesPopup() {
        cbsMasterActions.clickOnProceedBtnOnDiscardChangesPopup();
    }

    @And("Verify newly created service type should display under service type master section on cbs master page.")
    public void verifyNewlyCreatedServiceTypeShouldDisplayUnderServiceTypeMasterSectionOnCbsMasterPage() {
        cbsMasterActions.verifyNewlyCreatedServiceTypeShouldDisplay(getSession().getSharedData().get("serviceTypeName").toString());
    }

    @And("User enter the {string} on cbs master page.")
    public void userEnterTheOnCbsMasterPage(String arg0) {
        if (arg0.equals("<CharLimitExceed>")) {
            arg0 = faker.lorem().characters(201);
        }
        cbsMasterActions.enterTextInCreateRoleTxtBox(arg0);
    }

    @Then("Verify user should see the error message {string} on cbs master page.")
    public void verifyUserShouldSeeTheErrorMessageOnCbsMasterPage(String arg0) {
        String actMsg = cbsMasterActions.createRoleTxtErrorMsg();
        assertEquals("Validation failed for role name!", actMsg, arg0);
    }

    @Then("User enter below value in role name and verify appropriate error messages under create role popup on cbs master page.")
    public void userEnterBelowValueInRoleNameAndVerifyAppropriateErrorMessagesUnderCreateRolePopupOnCbsMasterPage(DataTable dataTable) {
        dataTable.asMaps(String.class, String.class).forEach(user -> {
            String roleName = user.get("roleName").replace("\"", "");

            if ("<maxCharacterLimitExceed>".equals(roleName)) {
                roleName = faker.lorem().characters(201);
            }
            cbsMasterActions.enterTextInCreateRoleTxtBox(roleName);

            if ("yes".equalsIgnoreCase(user.get("error"))) {
                cbsMasterActions.verifyRoleNameErrorMsgOnCreateRolePopup(user.get("errorMessage"));
            } else {
                cbsMasterActions.verifySubmitBtnShouldEnabledOnCreateRolePopup();
            }

            cbsMasterActions.clearRoleNameTxtBxOnCreateRolePopup();
        });
    }

    @And("User enter existing role name in role name txt box on cbs master page.")
    public void userEnterExistingRoleNameInRoleNameTxtBoxOnCbsMasterPage() {
        String existingRoleName = cbsMasterActions.getRoleNameValues().
                get(faker.random().nextInt(0, cbsMasterActions.getRoleNameValues().size()));
        cbsMasterActions.enterTextInCreateRoleTxtBox(existingRoleName);
    }

    @And("User click on submit button under create role name popup on cbs master page.")
    public void userClickOnSubmitButtonUnderCreateRoleNamePopupOnCbsMasterPage() {
        cbsMasterActions.clickSubmitButtonOnCreateRoleNamePopup();
    }

    @Then("Verify error message for duplicate role name should display on cbs master page.")
    public void verifyErrorMessageForDuplicateRoleNameShouldDisplayOnCbsMasterPage() {
        cbsMasterActions.verifyErrorMessageForDuplicateRoleName();
    }


    @And("User enter valid role name in role name txt box on cbs master page.")
    public void userEnterValidRoleNameInRoleNameTxtBoxOnCbsMasterPage() {
        getSession().setSharedData("validName", faker.name().firstName());
        cbsMasterActions.enterTextInCreateRoleTxtBox(getSession().getSharedData("validName"));
    }

    @Then("Verify success toaster message display on cbs master page.")
    public void verifySuccessToasterMessageDisplayOnCbsMasterPage() {
        cbsMasterActions.verifyCreatedSuccessfullyToasterMsg();
    }

    @And("Verify same entry should shown in cbs role table on cbs master page.")
    public void verifySameEntryShouldShownInCbsRoleTableOnCbsMasterPage() {
        ArrayList<String> roleNameValues = cbsMasterActions.getRoleNameValues();
        cbsMasterActions.verifyContains(roleNameValues, getSession().getSharedData("validName"));
    }

    @Then("Verify discard changes popup ui.")
    public void verifyDiscardChangesPopupUi() {
        cbsMasterActions.verifyTitleShouldDisplayOnDiscardChangesPp(loadCbsMasterProps().getDiscardChangesPopupTitle());
        cbsMasterActions.verifyMsgShouldDisplayOnDiscardChangesPp(loadCbsMasterProps().getDiscardChangesPopupMsg());
        cbsMasterActions.verifyCancelButtonShouldDisplayOnDiscardChangesPp();
        cbsMasterActions.verifyProceedButtonShouldDisplayOnDiscardChangesPp();
    }

    @And("Verify service type should be prefilled on create service type popup.")
    public void verifyServiceTypeShouldBePrefilledOnCreateServiceTypePopup() {
        cbsMasterActions.verifyServiceTypeShouldBePrefilledOnCreateServiceTypePopup();
    }

    @And("Verify discard changes popup should not display.")
    public void verifyDiscardChangesPopupShouldNotDisplay() {
        cbsMasterActions.verifyDiscardChangesPpShouldNotDisplay(loadCbsMasterProps().getDiscardChangesPopupTitle());
    }

    @Then("Verify loader display during data fetching on cbs master page.")
    public void verifyLoaderDisplayDuringDataFetchingOnCbsMasterPage() {
        cbsMasterActions.verifyLoaderDisplayDuringDataFetchingOnCbsMasterPage();
    }

    @Then("Verify pressing enter on a CTA simulates a mouse click event.")
    public void verifyPressingEnterOnACTASimulatesAMouseClickEvent() {
        cbsMasterActions.verifyPressingEnterOnACTASimulatesAMouseClickEvent();
        sleep(2000);
        cbsMasterActions.verifyCreateServiceTypePopupShouldDisplay();

    }

    @And("Verify pressing esc on a popup simulates clicking cancel.")
    public void verifyPressingEscOnAPopupSimulatesClickingCancel() {
        cbsMasterActions.verifyPressingEscOnAPopupSimulatesClickingCancel();
        sleep(2000);
        cbsMasterActions.verifyCreateServiceTypePopupShouldNotDisplay();
    }

    @And("User enter value in role name txt box on cbs master page.")
    public void userEnterValueInRoleNameTxtBoxOnCbsMasterPage() {
        cbsMasterActions.enterTextInCreateRoleTxtBox(faker.name().firstName());
    }

    @And("User click cancel button under create role master popup on cbs master page.")
    public void userClickCancelButtonUnderCreateRoleMasterPopupOnCbsMasterPage() {
        cbsMasterActions.clickCancelOnCreateRolePopup();
    }

    @Then("Verify confirmation popup on cancellation after modifying some data on cbs master page.")
    public void verifyConfirmationPopupOnCancellationAfterModifyingSomeDataOnCbsMasterPage() {
        verifyDiscardChangesPopupUi();
    }
}
