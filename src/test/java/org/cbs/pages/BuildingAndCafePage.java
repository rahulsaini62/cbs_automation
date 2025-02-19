package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

@Getter
public class BuildingAndCafePage {

    private static final BuildingAndCafePage BUILDING_AND_CAFE_PAGE = new BuildingAndCafePage();

    /**
     * Gets Cbs Master page instance.
     *
     * @return Cbs Master page instance
     */
    public static BuildingAndCafePage buildingAndCafePage() {
        return BUILDING_AND_CAFE_PAGE;
    }

    private final Locator buildingMasterTitle = Locator.buildLocator()
            .web(xpath("//p[text()='Building Master']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Building Master Title")
            .build();

    private final Locator createBuildingBtn = Locator.buildLocator()
            .web(xpath("//button[text()='Create Building']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Create Building Button")
            .build();

    private final Locator cafeMasterTitle = Locator.buildLocator()
            .web(xpath("//p[text()='Cafe Master']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cafe Master Title")
            .build();

    private final Locator createCafeBtn = Locator.buildLocator()
            .web(xpath("//button[text()='Create Cafe']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Create Cafe Button")
            .build();

    private final Locator titleOnCreateBuildingPopup = Locator.buildLocator()
            .web(xpath("//h1[text()='Create']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Create Cafe Button")
            .build();

    public final Locator getGivenFieldLabelOnCreateBuildingPopup(String name) {
        return Locator.buildLocator()
                .web(xpath("//label[text()='" + name + "']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Create Cafe Button")
                .build();
    }

    private final Locator buildingNameTxtBxOnCreateBuildingPopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//input[@type='text']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Building Name Text Box")
            .build();

    private final Locator cancelBtnOnCreateBuildingPopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='button']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cancel Button")
            .build();

    private final Locator submitBtnOnCreateBuildingPopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='submit']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Submit Button")
            .build();

    public final Locator getGivenBuildingNameFromBuildingMasterTable(String name) {
        return Locator.buildLocator()
                .web(xpath(String.format("//td[text()='%s']",name)))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Create Cafe Button")
                .build();
    }

    public final Locator getGivenBuildingNameStatusFromBuildingMasterTable(String name) {
        return Locator.buildLocator()
                .web(xpath("//td[text()='" + name + "']/..//input"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Create Cafe Button")
                .build();
    }

    private final Locator titleOnCreateCafePopup = Locator.buildLocator()
            .web(xpath("//h1[text()='Create']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Create Cafe Button")
            .build();

    public final Locator getGivenFieldLabelOnCreateCafePopup(String name) {
        return Locator.buildLocator()
                .web(xpath("//label[text()='" + name + "']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Create Cafe Button")
                .build();
    }

    public final Locator getCafeNameTxtBxOnCreateCafePopup (String name){
        return Locator.buildLocator()
                .web(xpath("//label[text()='"+name+"']/..//input"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Building Name Text Box")
                .build();
    }

    public final Locator getBuildingTextBoxOnCreateCafePopup (String name){
        return Locator.buildLocator()
                .web(xpath("//p[text()='"+name+"']/..//input"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Building Name Text Box")
                .build();
    }

    public final Locator getBuildingDropdownOnCreateCafePopup (String name){
        return Locator.buildLocator()
                .web(xpath("//p[text()='"+name+"']/..//div[contains(@class,'dropdown')]"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Building Name Text Box")
                .build();
    }

    private final Locator cancelBtnOnCreateCafePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='button']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Cancel Button")
            .build();

    private final Locator submitBtnOnCreateCafePopup = Locator.buildLocator()
            .web(xpath("//div[@class='popup-body']//button[@type='submit']"))
            .android(accessibilityId("test-CHECKOUT"))
            .ios(accessibilityId("test-CHECKOUT"))
            .name("Submit Button")
            .build();

    public final Locator getBuildingDpDnOnCreateCafePopup (String value){
        return Locator.buildLocator()
                .web(xpath("//div[text()='"+value+"']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Building Name Text Box")
                .build();
    }

    public final Locator getBuildingDropdownLabelOnCreateCafePopup(String name) {
        return Locator.buildLocator()
                .web(xpath("//p[text()='"+name+"']"))
                .android(accessibilityId("test-CHECKOUT"))
                .ios(accessibilityId("test-CHECKOUT"))
                .name("Create Cafe Button")
                .build();
    }

}
