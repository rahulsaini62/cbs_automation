package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;

@Getter
public class SimulationsPage {
    private static final SimulationsPage SIMULATIONS_PAGE = new SimulationsPage();

    /**
     * Gets Simulations page instance.
     *
     * @return Simulations page instance
     */
    public static SimulationsPage simulationsPage() {
        return SIMULATIONS_PAGE;
    }

    private final Locator pageTitle = Locator.buildLocator()
            .web(cssSelector("//p[text()='Simulations']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Simulations page title")
            .build();


}
