package org.cbs.actions;

import org.apache.logging.log4j.Logger;
import org.cbs.enums.PlatformType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.pages.BuildingAndCafePage.buildingAndCafePage;
import static org.cbs.pages.EventsPage.eventsPage;

public class EventsActions extends SharedActions {
    SoftAssert softAssert = new SoftAssert();
    private final PlatformType platformType;
    private static final Logger log = getLogger();

    public EventsActions() {
        this.platformType = getSession().getPlatformType();
    }

    public void verifyEventsPageShouldDisplay() {
        Assert.assertTrue(verifyElementIsDisplayed(eventsPage().getEventsTitle()),
                "Building & Cafe page is not displayed");
    }

}
