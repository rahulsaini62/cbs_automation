package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.waitForElementInvisibility;
import static org.cbs.actions.elements.ElementFinder.waitForElementVisible;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.BuildingAndCafePage.buildingAndCafePage;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.pages.SiteProfilePage.siteProfilePage;

public class BuildingAndCafeActions extends SharedActions {
    SoftAssert softAssert = new SoftAssert();
    private final PlatformType platformType;
    private static final Logger log = getLogger();

    public BuildingAndCafeActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void verifyBuildingAndCafePageShouldDisplay() {
        waitForThePageLoader();
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getBuildingMasterTitle()),
                "Building & Cafe page is not displayed");
        sleep(2000);
    }

    public void clickOnCreateBuildingBtn() {
        waitForThePageLoader();
        waitForElementVisible(buildingAndCafePage().getCreateBuildingBtn());
        withMouse(buildingAndCafePage().getCreateBuildingBtn()).click();
    }

    public void clickOnCreateCafeBtn() {
        withMouse(buildingAndCafePage().getCreateCafeBtn()).click();
    }

    public void verifyTitleOnCreateBuildingPopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getTitleOnCreateBuildingPopup()),
                "Crete Building popup is not displayed");
    }

    public void verifyBuildingNameLabelShouldDisplayOnCreateBuildingPopup(String fieldName) {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getGivenFieldLabelOnCreateBuildingPopup(fieldName)),
                "Crete Building popup is not displayed");
    }

    public void verifyBuildingNameTxtBxShouldDisplayOnCreateBuildingPopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getBuildingNameTxtBxOnCreateBuildingPopup()),
                "Crete Building popup is not displayed");
    }

    public void verifyCancelBtnShouldDisplayOnCreateBuildingPopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getCancelBtnOnCreateBuildingPopup()),
                "Crete Building popup is not displayed");
    }

    public void verifySubmitBtnShouldDisplayOnCreateBuildingPopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getSubmitBtnOnCreateBuildingPopup()),
                "Crete Building popup is not displayed");
    }

    public void enterInBuildingNameTxtBx(String buildingName) {
        onTextBox(buildingAndCafePage().getBuildingNameTxtBxOnCreateBuildingPopup()).enterText(buildingName);
    }

    public void clickOnSubmitBtnOnCreateBuildingPopup() {
        withMouse(buildingAndCafePage().getSubmitBtnOnCreateBuildingPopup()).click();
        sleep(2000);
        waitForElementInvisibility(buildingAndCafePage().getSubmitBtnOnCreateBuildingPopup());
    }

    public void verifyGivenBuildingShouldDisplayUnderBuildingMasterOnBuildingAndCafePage(String name) {
        waitForThePageLoader();
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getGivenBuildingNameFromBuildingMasterTable(name)),
                "Newly Building named as " + name + " is not displayed");
    }

    public void verifyGivenBuildingShouldActiveStatusUnderBuildingMasterOnBuildingAndCafePage(String name) {
        Assert.assertTrue(onElement(buildingAndCafePage().getGivenBuildingNameStatusFromBuildingMasterTable(name)).isSelected(),
                "Newly Building as " + name + " is not active");
    }

    public void verifyTitleOnCreateCafePopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getTitleOnCreateCafePopup()),
                "Crete Building popup is not displayed");
    }

    public void verifyCafeNameLabelShouldDisplayOnCreateCafePopup(String fieldName) {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getGivenFieldLabelOnCreateCafePopup(fieldName)),
                "Cafe Name Field Label is not displayed");
    }

    public void verifyBuildingLabelShouldDisplayOnCreateCafePopup(String fieldName) {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getBuildingDropdownLabelOnCreateCafePopup(fieldName)),
                "Cafe Name Field Label is not displayed");
    }

    public void verifyCafeNameTxtBxShouldDisplayOnCreateBuildingPopup(String fieldName) {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getCafeNameTxtBxOnCreateCafePopup(fieldName)),
                "Cafe Name Field Text Box is not displayed");
    }

    public void verifyBuildingDropdownShouldDisplayOnCreateBuildingPopup(String fieldName) {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getBuildingDropdownOnCreateCafePopup(fieldName)),
                "Cafe Name Field Text Box is not displayed");
    }

    public void verifyCancelBtnShouldDisplayOnCreateCafePopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getCancelBtnOnCreateCafePopup()),
                "Crete Building popup is not displayed");
    }

    public void verifySubmitBtnShouldDisplayOnCreateCafePopup() {
        Assert.assertTrue(verifyElementIsDisplayed(buildingAndCafePage().getSubmitBtnOnCreateCafePopup()),
                "Crete Building popup is not displayed");
    }

    public void enterInCafeNameTxtBx(String cafeName, String value) {
        onTextBox(buildingAndCafePage().getCafeNameTxtBxOnCreateCafePopup(cafeName)).enterText(value);
        sleep(1000);
    }

    public void selectBuilding(String fieldName, String value) {

        withMouse(buildingAndCafePage().getBuildingDropdownOnCreateCafePopup(fieldName)).click();
        onTextBox(buildingAndCafePage().getBuildingTextBoxOnCreateCafePopup(fieldName)).enterText(value);
//        onTextBox(buildingAndCafePage().getBuildingDropdownOnCreateCafePopup(fieldName)).enterText(Keys.chord(Keys.RETURN));

//        withMouse(buildingAndCafePage().getBuildingDropdownOnCreateCafePopup(fieldName)).click();
//        sleep(1000);
        withMouse(buildingAndCafePage().getBuildingDpDnOnCreateCafePopup(value)).jsxClick();
    }

    public void selectServiceType(String fieldName, String value) {
        withMouse(buildingAndCafePage().getBuildingDropdownOnCreateCafePopup(fieldName)).click();
        sleep(1000);
        withMouse(buildingAndCafePage().getBuildingDpDnOnCreateCafePopup(value)).jsxClick();
    }

    public void clickOnSubmitBtnOnCreateCafePopup() {
        withMouse(buildingAndCafePage().getSubmitBtnOnCreateCafePopup()).click();
        waitForElementInvisibility(buildingAndCafePage().getSubmitBtnOnCreateCafePopup());
        waitForThePageLoader();
    }

}
