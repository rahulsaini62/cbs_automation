package org.cbs.steps;

import io.cucumber.java.en.And;
import org.cbs.actions.SimulationsActions;
import org.cbs.actions.TeamForThisBidActions;

public class TeamForThisBidSteps {

    private final TeamForThisBidActions teamForThisBidActions;

    public TeamForThisBidSteps() {
        this.teamForThisBidActions = new TeamForThisBidActions();
    }

    @And("User select team for this bid as {string} on team for this bid page.")
    public void userSelectTeamForThisBidAsOnTeamForThisBidPage(String value) {
        teamForThisBidActions.selectTeamForThisBidAsOnTeamForThisBidPage(value);
    }

    @And("User click on submit button on team for this bid page.")
    public void userClickOnSubmitButtonOnTeamForThisBidPage() {
        teamForThisBidActions.clickSubmitBtn();
    }

}
