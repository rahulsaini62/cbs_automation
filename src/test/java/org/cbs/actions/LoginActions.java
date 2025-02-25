package org.cbs.actions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.cbs.pages.LoginPage;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.drivers.DriverActions.withDriver;
import static org.cbs.actions.drivers.NavigateActions.navigate;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementFinder.waitForElementClickable;
import static org.cbs.actions.elements.ElementFinder.waitForURLContains;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.LoginPage.loginPage;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;

public class LoginActions extends SharedActions {
    private final PlatformType platformType;
    private static final Logger LOGGER = getLogger();

    public LoginActions() {

        this.platformType = getSession().getPlatformType();
    }

    public void enterInUsernameTxtBx(String userName) {
        onTextBox(LoginPage.loginPage()
                .getEmailTxt()).enterText(getApplicationProps(userName));
    }

    public void enterInPasswordTxtBx(String password) {
        onTextBox(loginPage().getPasswordTxt()).enterText(getApplicationProps(password));
    }

    public void populateLoginFormAndSignIn(final String userName, final String password) {
        enterInUsernameTxtBx(userName);
        withMouse(loginPage().getNextBtn()).click();
        sleep(2000);
        enterInPasswordTxtBx(password);
        sleep(1000);
        withMouse(loginPage().getSignInBtn()).click();
        sleep(2000);
        if (verifyElementIsDisplayed(loginPage().getStaySignInBtn())) {
            withMouse(loginPage().getStaySignInBtn()).click();
        }
        sleep(4000);
//        withMouse(loginPage().getStaySignInBtn()).click();
//        waitForURLContains("code");
//        waitForElementVisible(commonPage().getPageLoader());
//        waitForElementInvisibility(commonPage().getPageLoader());
        setTokenAndDeviceIdFromLocalStorage();
    }

    public void navigateToAppUrl(String appUrl) {
        navigate().to(getApplicationProps(appUrl));
    }

    public void loginWithGivenCred(final String userName, final String password) {
        populateLoginFormAndSignIn(userName, password);
    }

    public void setTokenAndDeviceIdFromLocalStorage() {
        String localStorageData = withDriver().executeScript("return localStorage.getItem(arguments[0]);",
                "access_token");
        LOGGER.info("Access token value: {}", localStorageData);

        getSession().setSharedData("token", "Bearer" + " " + localStorageData);

    }

}