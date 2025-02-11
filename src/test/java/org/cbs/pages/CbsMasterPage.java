package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

@Getter
public class CbsMasterPage {
    private static final CbsMasterPage CBS_MASTER_PAGE = new CbsMasterPage();

    /**
     * Gets Cbs Master page instance.
     *
     * @return Cbs Master page instance
     */
    public static CbsMasterPage cbsMasterPage() {
        return CBS_MASTER_PAGE;
    }

    private final Locator pageTitle = Locator.buildLocator()
            .web(xpath("//p[text()='Wastage Master']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("page title")
            .build();

    public final Locator getServiceTypeMasterSectionTitle(String titleName) {
        return Locator.buildLocator()
                .web(xpath("//p[text()='" + titleName + "']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Service Type Master Section Title")
                .build();
    }


}
