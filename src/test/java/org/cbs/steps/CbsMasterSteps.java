package org.cbs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.cbs.actions.CbsMasterActions;

public class CbsMasterSteps {

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
}
