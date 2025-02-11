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

    private final Locator createServiceTypeBtn = Locator.buildLocator()
            .web(xpath("//p[text()='Service Type Master']/..//button"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Service Type Master Button")
            .build();

    private final Locator titleOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//h1"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("title On Create Service Type Popup")
            .build();

    private final Locator serviceTypeNameFieldTitleOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//label"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Service Type Name Field Title On Create Service Type Popup")
            .build();

    private final Locator serviceTypeNameTxtBxOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//input"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Service Type Name Text Box On Create Service Type Popup")
            .build();

    private final Locator serviceTypeNameFieldErrorMsgOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//p"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Service Type Name Text Box On Create Service Type Popup")
            .build();

    private final Locator cancelBtnOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='button']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cancel Button On Create Service Type Popup")
            .build();

    private final Locator submitBtnOnCreateServiceTypePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='submit']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Submit Button On Create Service Type Popup")
            .build();

    private final Locator serviceTypeMasterTableColumnList = Locator.buildLocator()
            .web(xpath("//p[text()='Service Type Master']/../..//tr[1]//div[contains(@class,'Labels')]"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("service Type Master Table Column List")
            .build();

    private final Locator getGivenServiceTypeStatus (String serviceTypeName){
        return Locator.buildLocator()
                .web(xpath("//td[text()='"+serviceTypeName+"']/..//input"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("service Type Master Table Column List")
                .build();
    }
}
