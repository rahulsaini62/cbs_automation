package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.builders.Locator;
import org.cbs.enums.PlatformType;
import org.cbs.pages.SiteProfilePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.actions.CommonActions.sleep;
import static org.cbs.actions.elements.ClickableActions.withMouse;
import static org.cbs.actions.elements.ElementActions.onElement;
import static org.cbs.actions.elements.ElementFinder.*;
import static org.cbs.actions.elements.TextBoxActions.onTextBox;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.CbsMasterPage.cbsMasterPage;
import static org.cbs.pages.SiteProfilePage.siteProfilePage;

public class SiteProfileActions extends SharedActions {
    private final PlatformType platformType;
    private final SiteProfilePage siteProfilePage;
    private static final Logger LOGGER = getLogger();
    SoftAssert softAssert = new SoftAssert();

    public SiteProfileActions() {
        this.platformType = getSession().getPlatformType();
        this.siteProfilePage = new SiteProfilePage();
    }

    public void enterTextInTxtBox(Locator locator, String input) {
        withMouse(locator).click();
        onTextBox(locator).enterText(input);
        onTextBox(locator).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextSelectReferenceSite(String input) {
        withMouse(siteProfilePage.getSelectReferenceSiteDrpDown()).click();
        onTextBox(siteProfilePage.getSelectReferenceSiteTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getSelectReferenceSiteTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInSector(String input) {
        withMouse(siteProfilePage.getSectorDrpDown()).click();
        onTextBox(siteProfilePage.getSectorTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getSectorTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInOperatingModel(String input) {
        withMouse(siteProfilePage.getOperatingModelDrpDown()).click();
        onTextBox(siteProfilePage.getOperatingModelTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getOperatingModelTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInCity(String input) {
        withMouse(siteProfilePage.getCityDrpDown()).click();
        onTextBox(siteProfilePage.getCityTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getCityTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInContractType(String input) {
        withMouse(siteProfilePage.getContractTypeDrpDown()).click();
        onTextBox(siteProfilePage.getContractTypeTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getContractTypeTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void enterTextInContractDurationYear(String input) {
        withMouse(siteProfilePage.getContractDurationYearDrpDwn()).click();
        onTextBox(siteProfilePage.getContractDurationYearTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getContractDurationYearTxtBox()).enterText(Keys.chord(Keys.RETURN));

    }
    public void enterTextInContractDurationMonth(String input) {
        withMouse(siteProfilePage.getContractDurationMonthTxtBox()).click();
        onTextBox(siteProfilePage.getContractDurationMonthTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getContractDurationMonthTxtBox()).enterText(Keys.chord(Keys.RETURN));

    }

    public void verifySiteProfileNavigation() {
        onElement(siteProfilePage.getTitle()).verifyText().isEqualTo("Site Profile");
//        waitForElementVisible(siteProfilePage.getCreatedSuccessToaster());
//        waitForElementInvisibility(siteProfilePage.getCreatedSuccessToaster());
        waitForThePageLoader();
    }

    public void enterTextInRevenueAssuranceType(String input) {
        withMouse(siteProfilePage.getRevenueAssuranceDrpDown()).click();
        onTextBox(siteProfilePage.getRevenueAssuranceTypeTxtBox()).enterText(input);
        onTextBox(siteProfilePage.getRevenueAssuranceTypeTxtBox()).enterText(Keys.chord(Keys.RETURN));
    }

    public void bidSubmissionDateSelector(String input) {
        withMouse(siteProfilePage.getBidSubmissionDateInput()).click();
        waitForElementVisible(siteProfilePage.dateSelector(input));
        withMouse(siteProfilePage.dateSelector(input)).click();
    }

    public void estimatedMobilizationDateSelector(String input) {
        withMouse(siteProfilePage.getEstimateMobilizationDateInput()).click();
        waitForElementVisible(siteProfilePage.dateSelector(input));
        withMouse(siteProfilePage.getDateNextNav()).click();
        withMouse(siteProfilePage.dateSelector(input)).click();
        getSession().setSharedData
                ("estimateMobilizationDate",
                        onTextBox(siteProfilePage.getEstimateMobilizationDateInput()).getAttribute("value"));
    }

    public void enterTextInGasCostTxtBox(String input) {
        selectAllAndClearTxtBx(siteProfilePage.getGasCostTxtBox());
        onTextBox(siteProfilePage.getGasCostTxtBox()).enterText(input);

    }

    public void enterTextInYearOnYearTxtBox(String input) {
        selectAllAndClearTxtBx(siteProfilePage.getYearOnYearTxtBox());
        onTextBox(siteProfilePage.getYearOnYearTxtBox()).enterText(input);
    }

    public void clickValidateAPLBtn() {
        waitForElementInvisibility(siteProfilePage.getCreatedSuccessToaster());
        onElement(siteProfilePage.getValidateAPLBtn()).verifyIsEnabled();
        waitForElementClickable(siteProfilePage.getValidateAPLBtn());
        withMouse(siteProfilePage.getValidateAPLBtn()).click();
        waitForThePageLoader();
    }

    public void clickSaveSectionData() {
        onElement(siteProfilePage.getSaveSectionDataBtn()).verifyIsEnabled();
        waitForElementClickable(siteProfilePage.getSaveSectionDataBtn());
        withMouse(siteProfilePage.getSaveSectionDataBtn()).click();
//        waitForThePageLoader();
    }

    public void clickBuildingCafeBtn() {
//        waitForThePageLoader();
        onElement(siteProfilePage.getBuildingCafeBtn()).verifyIsEnabled();
        waitForElementClickable(siteProfilePage.getBuildingCafeBtn());
        withMouse(siteProfilePage.getBuildingCafeBtn()).click();
        waitForThePageLoader();
    }

    public void verifyGivenToastMessageShouldDisplay(String expectedToastMessage) {
        waitForElementVisible(siteProfilePage().getToastMsg());
        softAssert.assertEquals(onElement(siteProfilePage().getToastMsg()).getText(), expectedToastMessage, "Create Service Type Field Error Message on Create Service Type Popup is not displayed");
        softAssert.assertAll();
        waitForElementInvisibility(siteProfilePage.getToastMsg());
    }

}
