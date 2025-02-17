package org.cbs.actions;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.cbs.builders.Locator;
import org.cbs.enums.PlatformType;
import org.cbs.pages.SimulationsPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.SimulationsPage.simulationsPage;

@Getter
public class SimulationsActions extends SharedActions {

    private final PlatformType platformType;
    private final SimulationsPage simulationsPage;
    private static final Logger LOGGER = getLogger();

    public SimulationsActions() {
        this.platformType = getSession().getPlatformType();
        this.simulationsPage = new SimulationsPage();
    }

    public void verifySimulationsPageShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(simulationsPage().getPageTitle()),
                "Simulation page is not displayed");
    }

    public void clickOnCreateSimulationBtn(){
        sleep(3000);
        withMouse(simulationsPage().getCreateSimulationBtn()).jsxClick();
    }


}
