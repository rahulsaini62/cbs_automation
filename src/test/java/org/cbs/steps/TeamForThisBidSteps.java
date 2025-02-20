package org.cbs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.cbs.actions.SimulationsActions;
import org.cbs.actions.TeamForThisBidActions;

import static org.cbs.manager.ParallelSession.getSession;

public class TeamForThisBidSteps {

    private final TeamForThisBidActions teamForThisBidActions;

    public TeamForThisBidSteps() {
        this.teamForThisBidActions = new TeamForThisBidActions();
    }

    @And("User select team for this bid as {string} on team for this bid page.")
    public void userSelectTeamForThisBidAsOnTeamForThisBidPage(String value) {
        getSession().setSharedData("userName",value);
        teamForThisBidActions.selectTeamForThisBidAsOnTeamForThisBidPage(value);
    }

    @And("User click on submit button on team for this bid page.")
    public void userClickOnSubmitButtonOnTeamForThisBidPage() {
        teamForThisBidActions.clickSubmitBtn();
    }

    @Then("Verify selected user name and action shows in user list and action field on team for this bid page.")
    public void verifySelectedUserNameAndActionShowsInUserListAndActionFieldOnTeamForThisBidPage() {
        String userName = getSession().getSharedData("userName");
        teamForThisBidActions.verifyUserActionIcon(userName);
        teamForThisBidActions.verifyUserValue(userName);
    }
}
