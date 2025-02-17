package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.builders.Locator;
import org.cbs.enums.PlatformType;
import org.cbs.pages.SiteProfilePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.waitForElementInvisibility;
import static org.cbs.actions.elements.ElementFinder.waitForElementVisible;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;

public class SiteProfileActions extends SharedActions{
    private final PlatformType platformType;
    private final SiteProfilePage siteProfilePage;
    private static final Logger LOGGER = getLogger();

    public SiteProfileActions() {
        this.platformType = getSession().getPlatformType();
        this.siteProfilePage = new SiteProfilePage();
    }

    public void enterTextInTxtBox(Locator locator,String input){
        withMouse(locator).click();
        onTextBox(locator).enterText(input);
        onTextBox(locator).enterText(Keys.chord(Keys.RETURN));
    }
    public void enterTextSelectReferenceSite(String input){
        withMouse(siteProfilePage.getSelectReferenceSiteDrpDown()).click();
        onTextBox(siteProfilePage.getSelectReferenceSiteTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getSelectReferenceSiteTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInSector(String input){
        withMouse(siteProfilePage.getSectorDrpDown()).click();
        onTextBox(siteProfilePage.getSectorTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getSectorTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInOperatingModel(String input){
        withMouse(siteProfilePage.getOperatingModelDrpDown()).click();
        onTextBox(siteProfilePage.getOperatingModelTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getOperatingModelTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInCity(String input){
        withMouse(siteProfilePage.getCityDrpDown()).click();
        onTextBox(siteProfilePage.getCityTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getCityTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInContractType(String input){
        withMouse(siteProfilePage.getContractTypeDrpDown()).click();
        onTextBox(siteProfilePage.getContractTypeTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getContractTypeTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void verifySiteProfileNavigation(){
        onElement(siteProfilePage.getTitle()).verifyText().isEqualTo("Site Profile");
        waitForElementInvisibility(siteProfilePage.getCreatedSuccessToaster());
        waitForThePageLoader();
    }

    public void enterTextInRevenueAssuranceType(String input){
        withMouse(siteProfilePage.getRevenueAssuranceDrpDown()).click();
        onTextBox(siteProfilePage.getRevenueAssuranceTypeTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getRevenueAssuranceTypeTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

}
