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
            .web(xpath("//button[text()='Cancel']"))
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

    public final Locator getGivenServiceTypeName(String serviceTypeName) {
        return Locator.buildLocator()
                .web(xpath("//td[text()='" + serviceTypeName + "']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("service Type Master Table Column List")
                .build();
    }

    public final Locator getGivenServiceTypeStatus(String serviceTypeName) {
        return Locator.buildLocator()
                .web(xpath("//td[text()='" + serviceTypeName + "']/..//input"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("service Type Master Table Column List")
                .build();
    }


    private final Locator toastMessage = Locator.buildLocator()
            .web(cssSelector(".Toastify__toast-body"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("service Type Master Table Column List")
            .build();

    public final Locator getTitleOnDiscardChangesPopup(String name) {
        return Locator.buildLocator()
                .web(xpath("//h1[text()='" + name + "']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Cancel Button")
                .build();
    }


    private final Locator msgOnDiscardChangesPopup = Locator.buildLocator()
            .web(xpath("//h1/../..//p"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cancel Button")
            .build();

    private final Locator cancelBtnOnDiscardChangesPopup = Locator.buildLocator()
            .web(xpath("//h1[text()='Discard Changes']/../..//button[text()='Cancel']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cancel Button")
            .build();

    private final Locator proceedBtnOnDiscardChangesPopup = Locator.buildLocator()
            .web(xpath("//h1[text()='Discard Changes']/../..//button[text()='Proceed']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Proceed Button")
            .build();

    private final Locator roleMasterTitle = Locator.buildLocator()
            .web(xpath("//p[contains(text(),'Role Master')]"))
            .name("Role Master Title")
            .build();

    private final Locator roleMasterColumnsTxt = Locator.buildLocator()
            .web(xpath("//p[text()='Role Master']/../..//tr//div[contains(@class,'Labels')]"))
            .name("Role Master Columns Txt")
            .build();

    private final Locator createRoleBtn = Locator.buildLocator()
            .web(xpath("//button[contains(text(),'Create Role')]"))
            .name("Create Role Button")
            .build();

    private final Locator createRolePopupTitle = Locator.buildLocator()
            .web(cssSelector("h1.MuiTypography-h3"))
            .name("Create Role Popup Title")
            .build();

    private final Locator roleNameTxt = Locator.buildLocator()
            .web(xpath("//label[contains(text(),'Role Name')]"))
            .name("Role Name Txt")
            .build();

    private final Locator createRolePopupTxtBox = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//input"))
            .name("Create Role Popup Txt Box")
            .build();

    private final Locator createRolePopupBtnWrapper = Locator.buildLocator()
            .web(cssSelector("div.flex.al-center.js-center button"))
            .name("Create Role Popup Button Wrapper")
            .build();

    private final Locator createRolePopupCancelBtn = Locator.buildLocator()
            .web(cssSelector("div.popup-body div.flex.al-center.js-center > :first-child"))
            .name("Create Role Popup Cancel Btn")
            .build();

    private final Locator createRolePopupSubmitBtn = Locator.buildLocator()
            .web(cssSelector("div.popup-body div.flex.al-center.js-center :nth-child(2)"))
            .name("Create Role Popup Submite Btn")
            .build();

    private final Locator loginSuccessPopup = Locator.buildLocator()
            .web(xpath("//div[contains(text(),'Login successful')]"))
            .name("Login Success Popup")
            .build();

    private final Locator createRolePopupHelperMsg = Locator.buildLocator()
            .web(cssSelector("p.MuiFormHelperText-filled"))
            .name("Create Role Popup Helper Msg")
            .build();

    private final Locator roleNameValues = Locator.buildLocator()
            .web(cssSelector("div.for-rm tr[data-index]"))
            .name("Role Name Values")
            .build();

    private final Locator loader = Locator.buildLocator()
            .web(cssSelector("div.MuiBackdrop-root.css-5ezogp"))
            .name("Loader")
            .build();

    private final Locator createdSuccessfullyToaster = Locator.buildLocator()
            .web(xpath("//div[contains(text(),'Created successfully')]"))
            .name("Toaster for Created Successfully")
            .build();
}
