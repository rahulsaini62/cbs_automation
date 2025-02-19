package org.cbs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.cbs.actions.BuildingAndCafeActions;
import org.cbs.actions.EventsActions;

public class EventsSteps {

    private final EventsActions eventsActions;

    public EventsSteps() {
        this.eventsActions = new EventsActions();
    }

    Faker faker = new Faker();

    @Then("Verify events page should display.")
    public void verifyEventsPageShouldDisplay() {
        eventsActions.verifyEventsPageShouldDisplay();
    }

    @And("User clicks on events button.")
    public void userClicksOnEventsButton() {
        eventsActions.clickOnEvents();
    }

    @And("User enter {string} in event revenue index two text box on events page.")
    public void userEnterInEventRevenueIndexTextBoxOnEventsPage(String arg0) {
        eventsActions.enterTextInEventRevenueIndex2TxtBox(arg0);
    }

    @And("User click copy full term button on events page.")
    public void userClickCopyFullTermButtonOnEventsPage() {
        eventsActions.clickOnCopyToFullTermBtn();
    }

    @Then("User click on save section data btn on events page.")
    public void userClickOnSaveSectionDataBtnOnEventsPage() {
        eventsActions.clickOnSaveSectionDataBtn();
    }

    @And("User enter {string} in food cost index tow text box on events page.")
    public void userEnterInFoodCostIndexTowTextBoxOnEventsPage(String arg0) {
        eventsActions.enterTextInFoodCostIndex2TxtBox(arg0);
    }

    @And("Verify after click on copy to full team same value should reflect in each column on events page.")
    public void verifyAfterClickOnCopyToFullTeamSameValueShouldReflectInEachColumnOnEventsPage() {
        eventsActions.verifyAfterClickOnCopyToFullTeamSameValueShouldReflectInEachColumnOnEventsPage();
    }
}
