package org.cbs.actions;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.Logger;
import org.cbs.actions.api.ApiActions;
import org.cbs.api.restful.data.HeaderBuilder;
import org.cbs.api.restful.response.RoleMaster;
import org.cbs.api.restful.response.RoleMasterResponseDate;
import org.cbs.builders.ApiRequest;
import org.cbs.builders.ApiResponse;
import org.cbs.enums.PlatformType;
import org.cbs.enums.WaitStrategy;
import org.cbs.pages.CbsMasterPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.CommonActions.useKeys;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.*;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.api.restful.request.RoleMaster.getRoleMasterLogsRequest;
import static org.cbs.data.DataReader.loadCbsMasterProps;
import static org.cbs.enums.ApiConfigKey.TEST_RESTFUL_ADMIN;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.DashboardPage.commonPage;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.pages.SimulationsPage.simulationsPage;
import static org.cbs.pages.SiteProfilePage.siteProfilePage;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;
import static org.junit.Assert.assertTrue;

public class CbsMasterActions extends SharedActions {
    SoftAssert softAssert = new SoftAssert();
    private final PlatformType platformType;
    private static final Logger log = getLogger();
    HeaderBuilder headerBuilder = new HeaderBuilder();

    public CbsMasterActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void verifyCbsMasterPageShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getPageTitle()),
                "CBS Master page is not displayed");
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

    public void verifyCreateServiceTypePopupShouldNotDisplay() {
        Assert.assertFalse(verifyElementIsDisplayed(cbsMasterPage().getTitleOnCreateServiceTypePopup()),
                "Create Service Type Popup is not displayed");
    }

    public void clickOnCancelBtnOnCreateServiceTypePopup() {
        sleep(1000);
        withMouse(cbsMasterPage().getCancelBtnOnCreateServiceTypePopup()).jsxClick();
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
//        waitForElementVisible(cbsMasterPage().getToastMessage());
        waitForElementVisible(cbsMasterPage().getToastMessage());
        softAssert.assertEquals(onElement(cbsMasterPage().getToastMessage()).getText(), expectedToastMessage, "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
//        withMouse(siteProfilePage().getCrossIconOnToastMsg()).click();
        waitForElementInvisibility(cbsMasterPage().getToastMessage());
//        withMouse(siteProfilePage().getCrossIconOnToastMsg()).click();
    }

    public void verifyDiscardChangesPpShouldNotDisplay(String expectedMessage) {
        sleep(2000);
        softAssert.assertFalse(onElement(cbsMasterPage().getTitleOnDiscardChangesPopup(expectedMessage)).isDisplayedWithoutWait(), "Title is not as expected");
        softAssert.assertAll();
    }

    public void verifyTitleShouldDisplayOnDiscardChangesPp(String expectedMessage) {
        waitForElementVisible(cbsMasterPage().getTitleOnDiscardChangesPopup(expectedMessage));
        softAssert.assertTrue(onElement(cbsMasterPage().getTitleOnDiscardChangesPopup(expectedMessage)).isDisplayed(), "Title is not as expected");
        softAssert.assertAll();
    }

    public void verifyMsgShouldDisplayOnDiscardChangesPp(String expectedMessage) {
        softAssert.assertEquals(onElement(cbsMasterPage().getMsgOnDiscardChangesPopup()).getText(), expectedMessage, "Title is not as expected");
        softAssert.assertAll();
    }

    public void verifyCancelButtonShouldDisplayOnDiscardChangesPp() {
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getCancelBtnOnDiscardChangesPopup()));
        softAssert.assertAll();
    }

    public void verifyProceedButtonShouldDisplayOnDiscardChangesPp() {
        softAssert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getProceedBtnOnDiscardChangesPopup()));
        softAssert.assertAll();
    }

    public void clickOnCancelBtnOnDiscardChangesPopup() {
        withMouse(cbsMasterPage().getCancelBtnOnDiscardChangesPopup()).click();
        waitForElementInvisibility(cbsMasterPage().getCancelBtnOnDiscardChangesPopup());
    }

    public void clickOnProceedBtnOnDiscardChangesPopup() {
        withMouse(cbsMasterPage().getProceedBtnOnDiscardChangesPopup()).click();
        sleep(3000);
    }

    public void verifyNewlyCreatedServiceTypeShouldDisplay(String expectedServiceType) {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getGivenServiceTypeName(expectedServiceType)),
                "Newly Created Service Type not displayed");
    }

    public void verifyRoleMasterConfigurationVisibility() {
        waitForThePageLoader();
        onElement(cbsMasterPage().getRoleMasterTitle()).verifyText().isEqualTo(loadCbsMasterProps().getRoleMasterTitle());

        onElement(cbsMasterPage().getCreateRoleBtn()).verifyText().isEqualTo(loadCbsMasterProps().getCreateRoleTxt());

        List<String> expectedColumnNameList = loadCbsMasterProps().getRoleMasterColumnTxt();

        WebDriverWait wait = getSession().getWait();
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(finds(
                cbsMasterPage().getRoleMasterColumnsTxt())));

        List<String> actualColumnNameList = new ArrayList<>();
        for (WebElement element : elements) {
            actualColumnNameList.add(element.getText());
        }
        waitForThePageLoader();

    }

    public void clickCreateRoleButton() {
        waitForElementInvisibility(cbsMasterPage().getLoginSuccessPopup());
        waitForElementClickable(cbsMasterPage().getCreateRoleBtn());
        withMouse(cbsMasterPage().getCreateRoleBtn()).click();
    }

    public void verifyCreateRolePopupVisibility() {
        Assert.assertTrue((verifyElementIsDisplayed(cbsMasterPage().getCreateRolePopupTitle())), "Create Popup not visible");
        onElement(cbsMasterPage().getCreateRolePopupTitle()).verifyText().isEqualTo(loadCbsMasterProps().getCreateRolePopupTitle());

        onElement(cbsMasterPage().getRoleNameTxt()).verifyText().isEqualTo(loadCbsMasterProps().getRoleNameTxt());

        onElement(cbsMasterPage().getCreateRolePopupCancelBtn()).verifyIsEnabled().isTrue();

    }

    public void clearTextInCreateRoleTxtBox() {
        selectAllAndClearTxtBx(cbsMasterPage().getCreateRolePopupTxtBox());
    }

    public void enterTextInCreateRoleTxtBox(String text) {
        onTextBox(cbsMasterPage().getCreateRolePopupTxtBox()).enterText(text);
    }

    public String createRoleTxtErrorMsg() {
        return onElement(cbsMasterPage().getCreateRolePopupHelperMsg()).getText();
    }

    public void verifyRoleNameErrorMsgOnCreateRolePopup(String expectedErrorMessage) {
        softAssert.assertEquals(onElement(cbsMasterPage().getCreateRolePopupHelperMsg()).getText(),
                expectedErrorMessage, "Create Role Field Error Message on Create Role Popup not displayed");
        softAssert.assertAll();
    }

    public void verifySubmitBtnShouldEnabledOnCreateRolePopup() {
        softAssert.assertTrue(withMouse(cbsMasterPage().getCreateRolePopupSubmitBtn()).isEnabled());
    }

    public void clearRoleNameTxtBxOnCreateRolePopup() {
        onTextBox(cbsMasterPage().getCreateRolePopupTxtBox()).clear();
    }

    public ArrayList<String> getRoleNameValues() {
        ArrayList<String> roleNameValues = new ArrayList<>();
        finds(cbsMasterPage().getRoleNameValues(), WaitStrategy.VISIBLE).forEach(webElement -> roleNameValues.add(webElement.getText()));

        return roleNameValues;
    }

    public void clickSubmitButtonOnCreateRoleNamePopup() {
        withMouse(cbsMasterPage().getCreateRolePopupSubmitBtn()).click();
    }

    public void verifyErrorMessageForDuplicateRoleName() {
        waitForLoader();
        onElement(cbsMasterPage().getCreateRolePopupHelperMsg()).verifyText()
                .isEqualTo(loadCbsMasterProps().getDuplicateRoleNameErrorMsg());
    }

    public void waitForLoader() {
        waitForElementInvisibility(cbsMasterPage().getLoader());
    }

    public void verifyCreatedSuccessfullyToasterMsg() {
        waitForElementVisible(cbsMasterPage().getCreatedSuccessfullyToaster());
        onElement(cbsMasterPage().getCreatedSuccessfullyToaster()).verifyText().isEqualTo(loadCbsMasterProps().getCreatedSuccessMsg());
    }

    public void verifyServiceTypeShouldBePrefilledOnCreateServiceTypePopup() {
        sleep(3000);
        softAssert.assertEquals(onTextBox(cbsMasterPage().getServiceTypeNameTxtBxOnCreateServiceTypePopup()).getText(), getSession().getSharedData().get("serviceTypeName").toString());
        softAssert.assertAll();
    }

    public void verifyLoaderDisplayDuringDataFetchingOnCbsMasterPage() {
        waitForThePageLoader();
    }

    public void verifyPressingEnterOnACTASimulatesAMouseClickEvent() {
        sleep(1000);
        withMouse(cbsMasterPage().getCreateServiceTypeBtn()).hover();
        useKeys(Keys.ENTER);

    }

    public void verifyPressingEscOnAPopupSimulatesClickingCancel() {
        useKeys(Keys.ESCAPE);
    }

    public void clickCancelOnCreateRolePopup() {
        withMouse(cbsMasterPage().getCreateRolePopupCancelBtn()).click();
    }


    public RoleMasterResponseDate getRoleMasterListApi() {
        waitForThePageLoader();
        ApiRequest request;
        ApiResponse response;
        final Map<String, String> header = headerBuilder.buildHeaders();
        request = getRoleMasterLogsRequest(header);
        response = ApiActions.withRequest(request, TEST_RESTFUL_ADMIN.name()
                        .toLowerCase())
                .execute();

        // verifying Status code
        response.verifyStatusCode()
                .isEqualTo(200);
        final String jsonResponseString = response.getBody();
        Gson gson = new Gson();
        RoleMasterResponseDate roleMasterResponseDate = gson.fromJson(jsonResponseString, RoleMasterResponseDate.class);
//        System.out.println("1111111111----------" + roleMasterResponseDate.getData().stream().filter(RoleMaster-> RoleMaster.getName().equals("akjdsklv")).toString());

        // Define the name to search for
        String targetName = getSession().getSharedData("validName"); // You can change this to any name you're looking for

        // Verify and find the code for the given name
        List<RoleMaster> roleMasters = roleMasterResponseDate.getData();
        String foundCode = null;

        for (RoleMaster roleMaster : roleMasters) {
            if (roleMaster.getName() != null && roleMaster.getName().equals(targetName)) {
                foundCode = roleMaster.getCode();
                break;
            }
        }

        // Output the result
        if (foundCode != null) {
            System.out.println("Found code for name " + targetName + ": " + foundCode);
        } else {
            System.out.println("No matching role found for name " + targetName);
            throw new NullPointerException();
        }

        return roleMasterResponseDate;
    }

}
