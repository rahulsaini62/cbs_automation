package org.cbs.actions;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.enums.WaitStrategy;
import org.cbs.pages.CbsMasterPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.*;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.data.DataReader.loadCbsMasterProps;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.DashboardPage.commonPage;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.pages.SimulationsPage.simulationsPage;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;
import static org.junit.Assert.assertTrue;

public class CbsMasterActions extends SharedActions {
    SoftAssert softAssert;
    private final PlatformType platformType;
    private static final Logger LOGGER = getLogger();

    public CbsMasterActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void verifyCbsMasterPageShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getPageTitle()),
                "Simulation page is not displayed");
    }

    public void verifyServiceTypeMasterSectionTitleShouldDisplay(String titleName) {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getServiceTypeMasterSectionTitle(titleName)),
                "Service Type Master Section Title is not displayed");
    }

    public void verifyCreateServiceTypeBtnShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getCreateServiceTypeBtn()),
                "Create Service Type Btn is not displayed");
    }

    public void clickOnCreateServiceTypeBtn() {
        waitForElementVisible(cbsMasterPage().getCreateServiceTypeBtn());
        withMouse(cbsMasterPage().getCreateServiceTypeBtn()).jsxClick();
    }

    public void verifyCreateServiceTypePopupShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getTitleOnCreateServiceTypePopup()),
                "Create Service Type Popup is not displayed");
    }

    public void clickOnCancelBtnOnCreateServiceTypePopup() {
        withMouse(cbsMasterPage().getCancelBtnOnCreateServiceTypePopup()).click();
    }

    public void clickOnSubmitBtnOnCreateServiceTypePopup() {
        withMouse(cbsMasterPage().getSubmitBtnOnCreateServiceTypePopup()).click();
    }

    public void verifySubmitBtnShouldEnabledOnCreateServiceTypePopup() {
        softAssert.assertTrue(withMouse(cbsMasterPage().getSubmitBtnOnCreateServiceTypePopup()).isEnabled());
    }

    public void enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(String serviceTypeName) {
        onTextBox(cbsMasterPage().getServiceTypeNameTxtBxOnCreateServiceTypePopup()).enterText(serviceTypeName);
    }

    public void verifyGivenListOfColumnShouldDisplayCreateServiceTypePopup() {

        List<String> expectedColumnNameList = loadCbsMasterProps().getServiceTypeMasterTableColumn();

        List<String> actualColumnNameList = new ArrayList<>();
        finds(cbsMasterPage().getServiceTypeMasterTableColumnList(), WaitStrategy.VISIBLE).forEach(WebElement -> actualColumnNameList.add(WebElement.getText()));
        Assert.assertEquals(actualColumnNameList, expectedColumnNameList, "Column Name are not as per expected");
    }

    public void verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldDisplay(String expectedErrorMessage) {
        onElement(cbsMasterPage().getServiceTypeNameFieldErrorMsgOnCreateServiceTypePopup()).getText();
        softAssert.assertEquals(onElement(cbsMasterPage().getServiceTypeNameFieldErrorMsgOnCreateServiceTypePopup()).getText(), expectedErrorMessage, "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
    }

    public void verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldNotDisplay() {
        softAssert.assertFalse(verifyElementIsDisplayed(cbsMasterPage().getServiceTypeNameFieldErrorMsgOnCreateServiceTypePopup()), "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
    }

    public void activeInactiveGivenServiceTypeStatus(boolean condition){

    }

    public void verifyRoleMasterConfigurationVisibility(){
        onElement(cbsMasterPage().getRoleMasterTitle()).verifyText().isEqualTo(loadCbsMasterProps().getRoleMasterTitle());

        onElement(cbsMasterPage().getCreateRoleBtn()).verifyText().isEqualTo(loadCbsMasterProps().getCreateRoleTxt());

        List<String> expectedColumnNameList = loadCbsMasterProps().getRoleMasterColumnTxt();

        List<String> actualColumnNameList = new ArrayList<>();
        finds(cbsMasterPage().getRoleMasterColumnsTxt(), WaitStrategy.VISIBLE).forEach(WebElement -> actualColumnNameList.add(WebElement.getText()));
        Assert.assertEquals(actualColumnNameList, expectedColumnNameList, "Column Name are not as per expected");
    }

    public void clickCreateRoleButton(){
        waitForElementClickable(cbsMasterPage().getCreateRoleBtn());
        withMouse(cbsMasterPage().getCreateRoleBtn()).click();
    }

    public void verifyCreateRolePopupVisibility(){
        Assert.assertTrue((verifyElementIsDisplayed(cbsMasterPage().getCreateRolePopupTitle())),"Create Popup not visible");
        onElement(cbsMasterPage().getCreateRolePopupTitle()).verifyText().isEqualTo(loadCbsMasterProps().getCreateRolePopupTitle());

        onElement(cbsMasterPage().getRoleNameTxt()).verifyText().isEqualTo(loadCbsMasterProps().getRoleNameTxt());

        onElement(cbsMasterPage().getCreateRolePopupCancelBtn()).verifyIsEnabled().isTrue();

        onElement(cbsMasterPage().getCreateRolePopupSubmitBtn()).verifyIsEnabled().isFalse();



    }




}

