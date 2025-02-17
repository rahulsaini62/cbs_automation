package org.cbs.steps;

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

}
