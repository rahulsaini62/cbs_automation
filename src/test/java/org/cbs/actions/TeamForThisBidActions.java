package org.cbs.actions;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.pages.SimulationsPage;
import org.cbs.pages.TeamForThisBidPage;
import org.testng.Assert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.waitForElementInvisibility;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.SimulationsPage.simulationsPage;
import static org.cbs.pages.TeamForThisBidPage.teamForThisBidPage;

@Getter
public class TeamForThisBidActions extends SharedActions {

    private final PlatformType platformType;
    private static final Logger LOGGER = getLogger();

    public TeamForThisBidActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void selectTeamForThisBidAsOnTeamForThisBidPage(String value) {
        sleep(1000);
      withMouse(teamForThisBidPage().getTeamForThisBidValue(value)).click();
      withMouse(teamForThisBidPage().getPageTitle()).click();
    }

    public void clickSubmitBtn(){
        onElement(teamForThisBidPage().getSubmitBtn()).verifyIsEnabled();
        withMouse(teamForThisBidPage().getSubmitBtn()).click();
    }
    public void verifyUserValue(String userName){
        onElement(teamForThisBidPage().getUserValue(userName)).verifyIsDisplayed().isTrue();
    }
    public void verifyUserActionIcon(String userName){
        onTextBox(teamForThisBidPage().getUserActionIcon(userName)).verifyIsDisplayed().isTrue();
    }


}
