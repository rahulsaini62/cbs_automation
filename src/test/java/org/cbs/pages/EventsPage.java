package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

@Getter
public class EventsPage {

    private static final EventsPage EVENTS_PAGE = new EventsPage();

    /**
     * Gets Cbs Master page instance.
     *
     * @return Cbs Master page instance
     */
    public static EventsPage eventsPage() {
        return EVENTS_PAGE;
    }

    private final Locator eventsTitle = Locator.buildLocator()
            .web(xpath("//p[text()='Events']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Events Title")
            .build();

    private final Locator eventRevenueIndex2TxtBox = Locator.buildLocator()
            .web(xpath("(//td[contains(@data-index ,'2')] //input)[1]"))
            .name("Event Revenue Index 2 Txt Box")
            .build();

    private final Locator foodCostIndex2TxtBox = Locator.buildLocator()
            .web(xpath("(//td[contains(@data-index ,'2')] //input)[3]"))
            .name("Food Cost Index 2 Txt box")
            .build();

    private final Locator copyToFullTermBtn = Locator.buildLocator()
            .web(xpath("//button[contains(text(),'Copy')]"))
            .name("Copy to full term btn")
            .build();

    private final Locator saveSectionDataBtn = Locator.buildLocator()
            .web(xpath("//button[contains(text(),'Save')]"))
            .name("Save Section Data Btn")
            .build();

    private final Locator eventsBtn = Locator.buildLocator()
            .web(cssSelector("div.css-k008qs :nth-child(4)"))
            .name("Events Button")
            .build();
}
