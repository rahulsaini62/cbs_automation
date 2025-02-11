package org.cbs.appUtilities;

import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementFinder.waitForElementClickable;
import static org.cbs.actions.elements.ElementFinder.waitForElementVisible;
import static org.cbs.pages.DashboardPage.commonPage;

public class AppUtilities {

    public AppUtilities (){

    }

    /**
     * Logout from the application
     */
    public void logout(){
        waitForElementVisible (commonPage ().getUserImage ());
        withMouse(commonPage ().getUserImage ()).jsxClick();
        waitForElementVisible(commonPage ().getLogoutBtn ());
        withMouse(commonPage ().getLogoutBtn ()).jsxClick();
        waitForElementClickable(commonPage().getLastLogoutBtn());
        withMouse(commonPage().getLastLogoutBtn()).jsxClick();
        waitForElementVisible(commonPage().getLogoutToastMessage());
    }
}
