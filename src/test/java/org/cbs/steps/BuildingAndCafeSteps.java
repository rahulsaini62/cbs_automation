package org.cbs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.cbs.actions.BuildingAndCafeActions;
import org.cbs.actions.LoginActions;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.cbs.actions.SharedActions.verifyElementIsDisplayed;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.BuildingAndCafePage.buildingAndCafePage;

public class BuildingAndCafeSteps {

    private final BuildingAndCafeActions buildingAndCafeActions;

    public BuildingAndCafeSteps() {
        this.buildingAndCafeActions = new BuildingAndCafeActions();
    }

    Faker faker = new Faker();

    @Then("Verify building and cafe page should display.")
    public void verifyBuildingAndCafePageShouldDisplay() {

        buildingAndCafeActions.verifyBuildingAndCafePageShouldDisplay();
    }

    @When("User click create building button on building and cafe page.")
    public void userClickCreateBuildingButtonOnBuildingAndCafePage() {
        buildingAndCafeActions.clickOnCreateBuildingBtn();
    }

    @When("User click create cafe button on building and cafe page.")
    public void userClickCreateCafeButtonOnBuildingAndCafePage() {
        buildingAndCafeActions.clickOnCreateCafeBtn();
    }

    @Then("Verify create building popup should display.")
    public void verifyCreateBuildingPopupShouldDisplay() {
        buildingAndCafeActions.verifyTitleOnCreateBuildingPopup();
    }

    @And("Verify ui of create building popup.")
    public void verifyUiOfCreateBuildingPopup() {
        buildingAndCafeActions.verifyTitleOnCreateBuildingPopup();
        buildingAndCafeActions.verifyBuildingNameLabelShouldDisplayOnCreateBuildingPopup("Building Name");
        buildingAndCafeActions.verifyBuildingNameTxtBxShouldDisplayOnCreateBuildingPopup();
        buildingAndCafeActions.verifyCancelBtnShouldDisplayOnCreateBuildingPopup();
        buildingAndCafeActions.verifySubmitBtnShouldDisplayOnCreateBuildingPopup();
    }

    @When("User random enter building name on create building popup.")
    public void userRandomEnterBuildingNameOnCreateBuildingPopup() {
        getSession().getSharedData().put("buildingName", faker.lorem().characters(20));
        buildingAndCafeActions.enterInBuildingNameTxtBx(getSession().getSharedData().get("buildingName").toString());
    }

    @And("User click submit button on create building popup.")
    public void userClickSubmitButtonOnCreateBuildingPopup() {
        buildingAndCafeActions.clickOnSubmitBtnOnCreateBuildingPopup();
    }

    @And("Verify newly added building should display under building master on building and cafe page.")
    public void verifyNewlyAddedBuildingShouldDisplayUnderBuildingMasterOnBuildingAndCafePage() {
        buildingAndCafeActions.verifyGivenBuildingShouldDisplayUnderBuildingMasterOnBuildingAndCafePage(getSession().getSharedData().get("buildingName").toString());
    }

    @And("Verify newly added building should active status under building master on building and cafe page.")
    public void verifyNewlyAddedBuildingShouldActiveStatusUnderBuildingMasterOnBuildingAndCafePage() {
        buildingAndCafeActions.verifyGivenBuildingShouldActiveStatusUnderBuildingMasterOnBuildingAndCafePage(getSession().getSharedData().get("buildingName").toString());
    }

    @Then("Verify create cafe popup should display.")
    public void verifyCreateCafePopupShouldDisplay() {
        buildingAndCafeActions.verifyTitleOnCreateCafePopup();
    }

    @And("Verify ui of create cafe popup.")
    public void verifyUiOfCreateCafePopup() {
        buildingAndCafeActions.verifyTitleOnCreateCafePopup();
        buildingAndCafeActions.verifyCafeNameLabelShouldDisplayOnCreateCafePopup("Cafe Name");
        buildingAndCafeActions.verifyCafeNameTxtBxShouldDisplayOnCreateBuildingPopup("Cafe Name");
        buildingAndCafeActions.verifyBuildingLabelShouldDisplayOnCreateCafePopup("Building");
        buildingAndCafeActions.verifyBuildingDropdownShouldDisplayOnCreateBuildingPopup("Building");
        buildingAndCafeActions.verifyBuildingLabelShouldDisplayOnCreateCafePopup("Service Type");
        buildingAndCafeActions.verifyBuildingDropdownShouldDisplayOnCreateBuildingPopup("Service Type");
        buildingAndCafeActions.verifyCancelBtnShouldDisplayOnCreateCafePopup();
        buildingAndCafeActions.verifySubmitBtnShouldDisplayOnCreateCafePopup();
    }


    @When("User fill create cafe details and submit create cafe popup.")
    public void userFillCreateCafeDetailsAndSubmitCreateCafePopup() {
        getSession().getSharedData().put("cafeName", faker.lorem().characters(20));

        buildingAndCafeActions.enterInCafeNameTxtBx("Cafe Name", getSession().getSharedData().get("cafeName").toString());
        buildingAndCafeActions.selectBuilding("Building",getSession().getSharedData().get("buildingName").toString());
        buildingAndCafeActions.selectServiceType("Service Type", "02fwq9l2c876751geg0m");
        buildingAndCafeActions.clickOnSubmitBtnOnCreateCafePopup();

    }

    @And("Verify newly added cafe should display under cafe master on building and cafe page.")
    public void verifyNewlyAddedCafeShouldDisplayUnderCafeMasterOnBuildingAndCafePage() {
        buildingAndCafeActions.verifyGivenBuildingShouldDisplayUnderBuildingMasterOnBuildingAndCafePage(getSession().getSharedData().get("cafeName").toString());
    }

    @And("Verify newly added cafe should active status under cafe master on building and cafe page.")
    public void verifyNewlyAddedCafeShouldActiveStatusUnderCafeMasterOnBuildingAndCafePage() {
        buildingAndCafeActions.verifyGivenBuildingShouldActiveStatusUnderBuildingMasterOnBuildingAndCafePage(getSession().getSharedData().get("cafeName").toString());
    }
}
