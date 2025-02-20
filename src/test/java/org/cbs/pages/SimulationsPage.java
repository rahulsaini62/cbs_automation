package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import java.util.function.LongConsumer;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

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
            .web(xpath("//p[text()='Simulations']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Simulations page title")
            .build();

    private final Locator createSimulationBtn = Locator.buildLocator()
            .web(xpath("//p[text()='Simulations']/..//button"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Simulations page title")
            .build();



}
