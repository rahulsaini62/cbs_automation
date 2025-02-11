package org.cbs.actions;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.pages.CbsMasterPage;
import org.testng.Assert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.waitForElementVisible;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.DashboardPage.commonPage;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.pages.SimulationsPage.simulationsPage;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;

public class CbsMasterActions extends SharedActions{

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

    public void verifyCreateServiceTypeBtnShouldDisplay(){
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getCreateServiceTypeBtn()),
                "Create Service Type Btn is not displayed");
    }

    public void clickOnCreateServiceTypeBtn(){
        waitForElementVisible(cbsMasterPage().getCreateServiceTypeBtn());
        withMouse(cbsMasterPage().getCreateServiceTypeBtn()).jsxClick();
    }

    public void verifyCreateServiceTypePopupShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(cbsMasterPage().getTitleOnCreateServiceTypePopup()),
                "Create Service Type Popup is not displayed");
    }

    public void clickOnCancelBtnOnCreateServiceTypePopup(){
        withMouse(cbsMasterPage().getCancelBtnOnCreateServiceTypePopup()).click();
    }

    public void clickOnSubmitBtnOnCreateServiceTypePopup(){
        withMouse(cbsMasterPage().getSubmitBtnOnCreateServiceTypePopup()).click();
    }

    public void enterInServiceTypeNameTxtBxOnCreateServiceTypePopup(String serviceTypeName){
        onTextBox(cbsMasterPage().getServiceTypeNameTxtBxOnCreateServiceTypePopup()).enterText(serviceTypeName);
    }

    public void verifyGivenListOfColumnShouldDisplayCreateServiceTypePopup(DataTable dataTable){



    }
}
