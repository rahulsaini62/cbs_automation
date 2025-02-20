package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

@Getter
public class TeamForThisBidPage {

    private static final TeamForThisBidPage TEAM_FOR_THIS_BID_PAGE = new TeamForThisBidPage();

    /**
     * Gets Simulations page instance.
     *
     * @return Simulations page instance
     */
    public static TeamForThisBidPage teamForThisBidPage() {
        return TEAM_FOR_THIS_BID_PAGE;
    }

    private final Locator pageTitle = Locator.buildLocator()
            .web(xpath("//p[text()='Team for this Bid']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Simulations page title")
            .build();


    public final Locator getTeamForThisBidValue(String value) {
        return Locator.buildLocator()
                .web(xpath("//div[contains(text(),'" + value + "')]"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Simulations page title")
                .build();
    }
    public final Locator submitBtn = Locator.buildLocator()
            .web(xpath("//button[contains(text(),'Submit')]"))
            .name("Submit Button")
            .build();

    public final Locator getUserValue(String userName){
        return Locator.buildLocator()
                .web(xpath(String.format("//td[contains(text(),'%s')]",userName)))
                .name("User Name")
                .build();
    }

    public final Locator getUserActionIcon(String userName){
        return Locator.buildLocator()
                .web(xpath(String.format("//td[contains(text(),'%s')]/../..//button",userName)))
                .name("User Name Action Icon")
                .build();
    }

}
