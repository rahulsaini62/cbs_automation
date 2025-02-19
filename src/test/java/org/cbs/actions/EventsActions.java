package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.enums.WaitStrategy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

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

    public void verifyAfterClickOnCopyToFullTeamSameValueShouldReflectInEachColumnOnEventsPage() {

        final List<Double> actEventRevenue = new ArrayList<>();
        final List<Double> actFoodCost = new ArrayList<>();
        finds(eventsPage().getEventRevenueList(), WaitStrategy.VISIBLE).forEach(webElement -> actEventRevenue.add(Double.parseDouble(webElement.getAttribute("value"))));
        finds(eventsPage().getFoodCostList(), WaitStrategy.VISIBLE).forEach(webElement -> actFoodCost.add(Double.parseDouble(webElement.getAttribute("value"))));
        System.out.println("111111111----" + actEventRevenue);
        System.out.println("222222222222----" + actFoodCost);

        // List of lists of Doubles
        List<List<Double>> result = new ArrayList<>();

        // Divide the array into sublists of 12 numbers
        int start = 0;
        while (start < actEventRevenue.size()) {
            int end = Math.min(start + 12, actEventRevenue.size());
            List<Double> sublist = new ArrayList<>();

            // Add each number to the sublist
            for (int i = start; i < end; i++) {
                sublist.add(actEventRevenue.get(i));  // Directly adding the number
            }

            // Add the sublist to the result
            result.add(sublist);

            // Move the start index for the next chunk
            start = end;
        }
        System.out.println("eeeeeeee----" + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + "--------------------" + result.get(i));


            if (i == 0) {
                List<Double> values = result.get(i);
                values.remove(0);
                System.out.println("1111111111-----" + values);
                verifyAllMatch(values, 2.00);
//                for (int j = 1; j < values.size(); j++) {
//                    System.out.println("1111111111-----" + values.get(j));
//                    Assert.assertEquals(values.get(j), 2.00);
//                }
            } else if (i == (result.size() - 1)) {
                List<Double> values = result.get(i);
                values.remove(values.size() - 1);
                System.out.println("2222222222-----" + values);
                verifyAllMatch(values, 2.00);
            }
        }


    }

}
