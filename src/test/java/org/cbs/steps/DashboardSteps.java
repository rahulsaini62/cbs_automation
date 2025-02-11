package org.cbs.steps;

import io.cucumber.java.en.And;
import org.cbs.actions.DashboardActions;
import org.cbs.actions.SimulationsActions;

public class DashboardSteps {

    private final DashboardActions dashboardActions;

    public DashboardSteps() {
        this.dashboardActions = new DashboardActions();
    }

    @And("User click on {string} tab under menu on dashboard page.")
    public void userClickOnTabUnderMenuOnDashboardPage(String tabName) {
        dashboardActions.clickOnGivenTabUnderMenu(tabName);
    }

    @And("Verify user landed on the dashboard of the cbs web app.")
    public void verifyUserLandedOnTheDashboardOfTheCbsWebApp() {
    }


}
