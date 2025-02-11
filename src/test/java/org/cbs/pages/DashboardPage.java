package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

@Getter
public class DashboardPage {
    private static final DashboardPage COMMON_PAGE = new DashboardPage();

    /**
     * Gets Common page instance.
     *
     * @return Common page instance
     */
    public static DashboardPage commonPage() {
        return COMMON_PAGE;
    }

    private final Locator pageLoader = Locator.buildLocator()
            .web(cssSelector("div.circular-loader"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Page Loader")
            .build();

    public final Locator getCbsMasterTabUnderMenu(String tabName){
        return Locator.buildLocator()
                .web(xpath("//span[text()='"+tabName+"']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Page Loader")
                .build();
    }
    private final Locator tableLoader = Locator.buildLocator()
            .web(xpath("//table[@aria-label='loading table']"))
            .name("Table Loader")
            .build();
//
//    private final Locator userActionButton = Locator.buildLocator()
//            .web(cssSelector("div.actionBtnWrap :nth-child(2)"))
//            .name("User Action Button")
//            .build();
//
    private final Locator userImage = Locator.buildLocator()
            .web(cssSelector("#basic-button"))
            .name("User image")
            .build();
//
//    private final Locator logoutBtn = Locator.buildLocator()
//            .web(xpath("//li[text()='Logout']"))
//            .name("Logout button")
//            .build();
//
//    private final Locator auditLogBtn = Locator.buildLocator()
//        .web(xpath("//li[text()='Audit Log']"))
//        .name("Audit Log Button")
//        .build();
//
//    private final Locator lastLogoutBtn = Locator.buildLocator()
//            .web(xpath("//button[text()='Logout']"))
//            .name("Last Logout button")
//            .build();
//
//    private final Locator logoutToastMessage = Locator.buildLocator()
//            .web(cssSelector("div.alert-container"))
//            .name("Success logout toast message")
//            .build();
//
//    private final Locator sonyUsersTabUnderUserTabUnderMenu = Locator.buildLocator()
//            .web(xpath("//div[contains(@class,'MuiAccordionDetails')]//li[text()='Sonny’s Users']"))
//            .name("SonyUsers")
//            .build();
//    private final Locator clientsTabUnderUserTabUnderMenu = Locator.buildLocator()
//            .web(xpath("//div[contains(@class,'MuiAccordionDetails')]//li[text()='Clients']"))
//            .name("Clients")
//            .build();
//
//    private final Locator organizationsTabUnderUserTabUnderMenu = Locator.buildLocator()
//            .web(xpath("//div[contains(@class,'MuiAccordionDetails')]//li[text()='Organizations']"))
//            .name("Organizations")
//            .build();
//
//    private final Locator usersMenu = Locator.buildLocator()
//            .web(cssSelector("div[class*='MuiAccordionSummary-content']"))
//            .name("UsersMenu")
//            .build();
//
//    private final Locator selectAccount = Locator.buildLocator()
//            .web(xpath("//div[@aria-describedby='tileError loginHeader']"))
//            .name("Select Account")
//            .build();
//
//    private final Locator infoIcon = Locator.buildLocator()
//        .web(cssSelector("[class='infoIcon']"))
//        .name("Info Icon")
//        .build();
//
//    private final Locator toolTipText = Locator.buildLocator()
//        .web(cssSelector("[class='tooltipTitle']"))
//        .name("Tool Tip Text")
//        .build();
//
//    private final Locator accountIcon = Locator.buildLocator()
//        .web(cssSelector("[class='userText']"))
//        .name("Account Icon")
//        .build();
}