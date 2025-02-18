package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.*;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.BuildingAndCafePage.buildingAndCafePage;
import static org.cbs.pages.EventsPage.eventsPage;
import static org.cbs.pages.SiteProfilePage.siteProfilePage;

public class EventsActions extends SharedActions {
    SoftAssert softAssert = new SoftAssert();
    private final PlatformType platformType;
    private static final Logger log = getLogger();

    public EventsActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void verifyEventsPageShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(eventsPage().getEventsTitle()),
                "Events page is not displayed");
        waitForElementInvisibility(siteProfilePage().getCreatedSuccessToaster());
        waitForThePageLoader();
    }

    public void clickOnEvents(){
        waitForThePageLoader();
        onElement(eventsPage().getEventsBtn()).verifyIsEnabled();
        waitForElementClickable(siteProfilePage().getBuildingCafeBtn());
        withMouse(eventsPage().getEventsBtn()).click();
        waitForElementInvisibility(buildingAndCafePage().getBuildingMasterTitle());
    }


    public void clickOnSaveSectionDataBtn(){
        onElement(eventsPage().getSaveSectionDataBtn()).verifyIsEnabled();
        waitForElementClickable(eventsPage().getSaveSectionDataBtn());
        withMouse(eventsPage().getSaveSectionDataBtn()).click();
        waitForThePageLoader();
    }

    public void clickOnCopyToFullTermBtn(){
        onElement(eventsPage().getCopyToFullTermBtn()).verifyIsEnabled();
        waitForElementClickable(eventsPage().getCopyToFullTermBtn());
        withMouse(eventsPage().getCopyToFullTermBtn()).click();
    }

    public void enterTextInEventRevenueIndex2TxtBox(String input){
        selectAllAndClearTxtBx(eventsPage().getEventRevenueIndex2TxtBox());
        onTextBox(eventsPage().getEventRevenueIndex2TxtBox()).enterText(input);
    }

    public void enterTextInFoodCostIndex2TxtBox(String input){
        selectAllAndClearTxtBx(eventsPage().getFoodCostIndex2TxtBox());
        onTextBox(eventsPage().getFoodCostIndex2TxtBox()).enterText(input);
    }

}
