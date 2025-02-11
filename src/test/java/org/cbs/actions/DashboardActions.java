package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.pages.LoginPage;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;

public class DashboardActions extends SharedActions{

    private final PlatformType platformType;
    private static final Logger LOGGER = getLogger();

    public DashboardActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void enterInUsernameTxtBx(String userName) {
        onTextBox(LoginPage.loginPage()
                .getEmailTxt()).enterText(getApplicationProps(userName));
    }
}
