package org.cbs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.cbs.actions.CbsMasterActions;

public class CbsMasterSteps {

    private final CbsMasterActions cbsMasterActions;

    public CbsMasterSteps() {
        this.cbsMasterActions = new CbsMasterActions ();
    }

    @Then("Verify cbs master page should display.")
    public void verifyCbsMasterPageShouldDisplay() {
        cbsMasterActions.verifyCbsMasterPageShouldDisplay();
    }
}
