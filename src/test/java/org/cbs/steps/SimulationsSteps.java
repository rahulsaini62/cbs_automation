package org.cbs.steps;

import io.cucumber.java.en.And;
import org.cbs.actions.SimulationsActions;

import static org.cbs.actions.elements.ElementFinder.waitForElementInvisibility;
import static org.cbs.actions.elements.ElementFinder.waitForElementVisible;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;

public class SimulationsSteps {

    private final SimulationsActions simulationsActions;

    public SimulationsSteps() {
        this.simulationsActions = new SimulationsActions();
    }

    @And("Verify simulations page should display.")
    public void verifySimulationsPageShouldDisplay() {
        simulationsActions.verifySimulationsPageShouldDisplay();
        simulationsActions.waitForThePageLoader();
    }

    @And("User click create simulations button on simulations page.")
    public void userClickCreateSimulationsButtonOnSimulationsPage() {
        simulationsActions.clickOnCreateSimulationBtn();
    }
}
