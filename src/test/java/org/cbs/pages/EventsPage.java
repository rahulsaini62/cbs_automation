package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
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
            .name("Building Master Title")
            .build();
}
