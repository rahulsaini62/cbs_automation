package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.enums.WaitStrategy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    public void clickOnEvents() {
        waitForThePageLoader();
        onElement(eventsPage().getEventsBtn()).verifyIsEnabled();
        waitForElementClickable(siteProfilePage().getBuildingCafeBtn());
        withMouse(eventsPage().getEventsBtn()).click();
        waitForElementInvisibility(buildingAndCafePage().getBuildingMasterTitle());
    }


    public void clickOnSaveSectionDataBtn() {
        onElement(eventsPage().getSaveSectionDataBtn()).verifyIsEnabled();
        waitForElementClickable(eventsPage().getSaveSectionDataBtn());
        withMouse(eventsPage().getSaveSectionDataBtn()).click();
        waitForThePageLoader();
    }

    public void clickOnCopyToFullTermBtn() {
        onElement(eventsPage().getCopyToFullTermBtn()).verifyIsEnabled();
        waitForElementClickable(eventsPage().getCopyToFullTermBtn());
        withMouse(eventsPage().getCopyToFullTermBtn()).click();
    }

    public void enterTextInEventRevenueIndex2TxtBox(String input) {
        selectAllAndClearTxtBx(eventsPage().getEventRevenueIndex2TxtBox());
        onTextBox(eventsPage().getEventRevenueIndex2TxtBox()).enterText(input);
    }

    public void enterTextInFoodCostIndex2TxtBox(String input) {
        selectAllAndClearTxtBx(eventsPage().getFoodCostIndex2TxtBox());
        onTextBox(eventsPage().getFoodCostIndex2TxtBox()).enterText(input);
    }

    public void verifyAfterClickOnCopyToFullTeamSameValueShouldReflectInEachColumnOnEventsPage() {

        final List<Double> actEventRevenue = new ArrayList<>();
        final List<Double> actFoodCost = new ArrayList<>();
        finds(eventsPage().getEventRevenueList(), WaitStrategy.VISIBLE).forEach(webElement -> actEventRevenue.add(Double.parseDouble(webElement.getAttribute("value"))));
        finds(eventsPage().getFoodCostList(), WaitStrategy.VISIBLE).forEach(webElement -> actFoodCost.add(Double.parseDouble(webElement.getAttribute("value"))));

        verifyAllMatch(actFoodCost, Double.parseDouble(getSession().getSharedData("foodCost")));

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
        String dateStr = getSession().getSharedData("estimateMobilizationDate");
        Double percentage = Double.parseDouble(getSession().getSharedData("yearOnYearValue"))/100;

        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                List<Double> values = result.get(i);


                // Define the formatter to match the format "dd/MM/yyyy"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                // Parse the string to a LocalDate
                LocalDate givenDate = LocalDate.parse(dateStr, formatter);

                // Find the last day of the given month
                LocalDate lastDayOfMonth = givenDate.withDayOfMonth(givenDate.lengthOfMonth());

                // Calculate the remaining days from the given date to the last day of the month
                int remainingDays = (int) ChronoUnit.DAYS.between(givenDate, lastDayOfMonth) + 1; // Add 1 to include the given date

                // Calculate the total number of days in the month (length of the month)
                int totalDaysInMonth = givenDate.lengthOfMonth();

                Double l = ((Double.parseDouble(String.valueOf(remainingDays)) / (Double.parseDouble(String.valueOf(totalDaysInMonth))) * Double.parseDouble(getSession().getSharedData("revenue"))));

                Assert.assertEquals(values.get(0), Math.round(l * 100.0) / 100.0);

                values.remove(0);

                verifyAllMatch(values, Double.parseDouble(getSession().getSharedData("revenue")));
            } else if (i > 0 & i < result.size() - 1) {
                List<Double> values = result.get(i);
                Double increment = result.get(i - 1).get(1) + (result.get(i - 1).get(1) * percentage );
                verifyAllMatch(values, Math.round(increment * 100.0) / 100.0);
            } else if (i == (result.size() - 1)) {
                List<Double> values = result.get(i);


                // Define the formatter to match the format "dd/MM/yyyy"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                // Parse the string to a LocalDate
                LocalDate givenDate = LocalDate.parse(dateStr, formatter);

                // Add 4 years to the given date
                LocalDate futureDate = givenDate.plusYears(Integer.parseInt(getSession().getSharedData("contractDurationYear")));

                // Get the number of days in the future month
                int daysInFutureMonth = futureDate.lengthOfMonth();

                // Print the number of days in the future month

                // Get the first day of the future month
                LocalDate firstDayOfFutureMonth = futureDate.withDayOfMonth(1);

                // Calculate the number of days before the future date in the same month
                int daysBefore = (int) ChronoUnit.DAYS.between(firstDayOfFutureMonth, futureDate);

                // Calculate the total number of days in the month (length of the month)
                int totalDaysInMonth = futureDate.lengthOfMonth();


                Double increment = result.get(i - 1).get(1) + (result.get(i - 1).get(1) * percentage);
                if(values.size()>1){
                    verifyAllMatch(values.subList(0, values.size()-2), Math.round(increment * 100.0) / 100.0);
                }
                 Double l = ((Double.parseDouble(String.valueOf(daysBefore)) / (Double.parseDouble(String.valueOf(totalDaysInMonth))) * increment));
                    Assert.assertEquals(values.get(values.size()-1), Math.round(l * 100.0) / 100.0);


            }
        }


    }

}
