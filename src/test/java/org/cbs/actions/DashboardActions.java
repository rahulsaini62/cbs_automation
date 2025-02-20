package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.pages.DashboardPage;
import org.cbs.pages.LoginPage;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.waitForElementClickable;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.DashboardPage.commonPage;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;

public class DashboardActions extends SharedActions{

    private final PlatformType platformType;
    private static final Logger LOGGER = getLogger();

    public DashboardActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void clickOnGivenTabUnderMenu(String tabName) {
        waitForThePageLoader();
        waitForElementClickable(commonPage().getCbsMasterTabUnderMenu(tabName));
        withMouse(commonPage().getCbsMasterTabUnderMenu(tabName)).click();
        sleep(2000);
    }
}
