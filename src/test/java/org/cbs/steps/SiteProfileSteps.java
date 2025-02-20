package org.cbs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.cbs.actions.SiteProfileActions;
import org.cbs.actions.TeamForThisBidActions;
import org.cbs.pages.SiteProfilePage;

import static org.cbs.pages.SiteProfilePage.siteProfilePage;

public class SiteProfileSteps {
    private final Faker faker = new Faker();

    private final SiteProfileActions siteProfileActions;

    public SiteProfileSteps() {
        this.siteProfileActions = new SiteProfileActions();
    }


    @And("Verify user navigate to site profile page.")
    public void verifyUserNavigateToSiteProfilePage() {
        siteProfileActions.verifySiteProfileNavigation();
    }

    @And("User enter name in simulation name text box on site profile page.")
    public void userEnterNameInSimulationNameTextBoxOnSiteProfilePage() {
        String name = "automation_" + faker.lorem().characters(25);
        siteProfileActions.enterTextInTxtBox(siteProfilePage().getSimulationNameTxtBox(), name);
    }

    @And("User enter name in prospective site name text box on site profile page.")
    public void userEnterNameInProspectiveSiteNameTextBoxOnSiteProfilePage() {
        String siteName = faker.lorem().characters(30);
        siteProfileActions.enterTextInTxtBox(siteProfilePage().getProspectiveSiteNameTxtBox(), siteName);
    }

    @And("User enter {string} in select reference site on site profile page.")
    public void userEnterInSelectReferenceSiteOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextSelectReferenceSite(arg0);
    }

    @And("User enter {string} in sector txt box on site profile page.")
    public void userEnterInSectorTxtBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInSector(arg0);
    }

    @And("User enter {string} in operating model text box on site profile page.")
    public void userEnterInOperatingModelTextBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInOperatingModel(arg0);
    }

    @And("User enter {string} in city text box on site profile page.")
    public void userEnterInCityTextBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInCity(arg0);
    }

    @And("User enter {string} in contract type on site profile page.")
    public void userEnterInContractTypeOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInContractType(arg0);
    }

    @And("User enter {string} in revenue assurance type on site profile page.")
    public void userEnterInRevenueAssuranceTypeOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInRevenueAssuranceType(arg0);
    }

    @And("User select {string} in bid submission date on site profile page.")
    public void userSelectInBidSubmissionDateOnSiteProfilePage(String arg0) {
        siteProfileActions.bidSubmissionDateSelector(arg0);
    }

    @And("User select {string} in estimated mobilization date on site profile page.")
    public void userSelectInEstimatedMobilizationDateOnSiteProfilePage(String arg0) {
        siteProfileActions.estimatedMobilizationDateSelector(arg0);
    }

    @And("User enter {string} in year on year txt box on site profile page.")
    public void userEnterInYearOnYearTxtBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInYearOnYearTxtBox(arg0);

    }

    @And("User enter {string} in  gas cost txt box on site profile page.")
    public void userEnterInGasCostTxtBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInGasCostTxtBox(arg0);
    }

    @And("User click on save section data btn on site profile page.")
    public void userClickOnSaveSectionDataBtnOnSiteProfilePage() {
        siteProfileActions.clickSaveSectionData();
//        siteProfileActions.waitForThePageLoader();
    }

    @And("User click on validate apl btn on site profile page.")
    public void userClickOnValidateAplBtnOnSiteProfilePage() {
        siteProfileActions.clickValidateAPLBtn();
    }

    @And("User click on building & cafe btn on site profile page.")
    public void userClickOnBuildingCafeBtnOnSiteProfilePage() {
        siteProfileActions.clickBuildingCafeBtn();


    }

    @Then("Verify {string} toast message should display on site profile page.")
    public void verifyToastMessageShouldDisplayOnSiteProfilePage(String expectedToastMessage) {
        siteProfileActions.verifyGivenToastMessageShouldDisplay(expectedToastMessage);
    }

    @And("User enter {string} in contract duration year text box on site profile page.")
    public void userEnterInContractDurationYearTextBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInContractDurationYear(arg0);
    }


    @And("User enter {string} in contract duration month text box on site profile page.")
    public void userEnterInContractDurationMonthTextBoxOnSiteProfilePage(String arg0) {
        siteProfileActions.enterTextInContractDurationMonth(arg0);
    }
}
