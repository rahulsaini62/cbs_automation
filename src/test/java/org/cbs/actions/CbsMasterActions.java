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

public class CbsMasterActions extends SharedActions {
    SoftAssert softAssert = new SoftAssert();
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

    public void clearServiceTypeNameTxtBxOnCreateServiceTypePopup() {
        onTextBox(cbsMasterPage().getServiceTypeNameTxtBxOnCreateServiceTypePopup()).clear();
    }

    public void verifyGivenListOfColumnShouldDisplayCreateServiceTypePopup() {

        List<String> expectedColumnNameList = loadCbsMasterProps().getServiceTypeMasterTableColumn();

        List<String> actualColumnNameList = new ArrayList<>();
        finds(cbsMasterPage().getServiceTypeMasterTableColumnList(), WaitStrategy.VISIBLE).forEach(WebElement -> actualColumnNameList.add(WebElement.getText()));
        Assert.assertEquals(actualColumnNameList, expectedColumnNameList, "Column Name are not as per expected");
    }

    public void verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldDisplay(String expectedErrorMessage) {
        softAssert.assertEquals(onElement(cbsMasterPage().getServiceTypeNameFieldErrorMsgOnCreateServiceTypePopup()).getText(), expectedErrorMessage, "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
    }

    public void verifyServiceTypeNameFieldErrorMsgOnCreateServiceTypePopupShouldNotDisplay() {
        softAssert.assertFalse(verifyElementIsDisplayed(cbsMasterPage().getServiceTypeNameFieldErrorMsgOnCreateServiceTypePopup()), "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
    }

    public void activeInactiveGivenServiceTypeStatus(String serviceTypeName, boolean condition) {
        if (condition) {
            if (!withMouse(cbsMasterPage().getGivenServiceTypeStatus(serviceTypeName)).isEnabled()) {
                withMouse(cbsMasterPage().getGivenServiceTypeStatus(serviceTypeName)).click();
            }
        } else {
            if (withMouse(cbsMasterPage().getGivenServiceTypeStatus(serviceTypeName)).isEnabled()) {
                withMouse(cbsMasterPage().getGivenServiceTypeStatus(serviceTypeName)).click();
            }
        }
    }

    public void verifyServiceTypeNameFieldShouldDisplayOnCreateServiceTypePopup() {
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getServiceTypeNameFieldTitleOnCreateServiceTypePopup()), "");
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getServiceTypeNameTxtBxOnCreateServiceTypePopup()), "");
        softAssert.assertAll();
    }

    public void verifyCancelBtnShouldDisplayOnCreateServiceTypePopup() {
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getCancelBtnOnCreateServiceTypePopup()), "");
        softAssert.assertAll();
    }

    public void verifyCancelBtnShouldEnabledDisplayOnCreateServiceTypePopup() {
        softAssert.assertTrue(withMouse(cbsMasterPage().getCancelBtnOnCreateServiceTypePopup()).isEnabled(), "");
        softAssert.assertAll();
    }

    public void verifySubmitBtnShouldDisplayOnCreateServiceTypePopup() {
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getSubmitBtnOnCreateServiceTypePopup()), "");
        softAssert.assertAll();
    }

    public void verifySubmitBtnShouldDisabledOnCreateServiceTypePopup() {
        softAssert.assertFalse(withMouse(cbsMasterPage().getSubmitBtnOnCreateServiceTypePopup()).isEnabled(), "");
        softAssert.assertAll();
    }

    public void verifyGivenToastMessageShouldDisplay(String expectedToastMessage) {
        softAssert.assertEquals(onElement(cbsMasterPage().getToastMessage()).getText(), expectedToastMessage, "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
    }

    public void clickOnCancelBtnOnDiscardChangesPopup() {
        withMouse(cbsMasterPage().getCancelBtnOnDiscardChangesPopup()).click();
    }

    public void clickOnProceedBtnOnDiscardChangesPopup() {
        withMouse(cbsMasterPage().getProceedBtnOnDiscardChangesPopup()).click();
    }

    public void verifyNewlyCreatedServiceTypeShouldDisplay(String expectedServiceType) {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getGivenServiceTypeName(expectedServiceType)),
                "Newly Created Service Type not displayed");
    }
}
