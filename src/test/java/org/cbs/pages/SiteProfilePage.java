package org.cbs.pages;

import lombok.Getter;
import org.cbs.builders.Locator;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
@Getter
public class SiteProfilePage {
    private static final SiteProfilePage SITE_PROFILE_PAGE = new SiteProfilePage();

    /**
     * Gets Simulations page instance.
     *
     * @return Simulations page instance
     */
    public static SiteProfilePage siteProfilePage() {
        return SITE_PROFILE_PAGE;
    }

    private final Locator title = Locator.buildLocator()
            .web(xpath("//p[contains(text(),'Site Profile')]"))
            .name("Title")
            .build();

    private final Locator simulationNameTxtBox = Locator.buildLocator()
            .web(xpath("//input[contains(@name,'name')]"))
            .name("Simulation Name Txt Box")
            .build();

    private final Locator prospectiveSiteNameTxtBox = Locator.buildLocator()
            .web(xpath("//input[contains(@name,'prospectiveSiteName')]"))
            .name("Prospective Site Name Txt Box")
            .build();


    private final Locator selectReferenceSiteDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='Select Reference Site']/..//div[contains(@class,'css-1k0rgcj-indicatorContainer')]"))
            .name("Select Reference Site Drop Down")
            .build();

    private final Locator selectReferenceSiteTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='Select Reference Site']/..//input"))
            .name("Select Reference Site Txt Box")
            .build();

    private final Locator sectorDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='Sector']/..//div[contains(@class,'css-1k0rgcj-indicatorContainer')]"))
            .name("Sector Drop Down")
            .build();

    private final Locator sectorTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='Sector']/..//input"))
            .name("Sector Txt Box")
            .build();

    private final Locator operatingModelDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='Operating Model']/..//div[contains(@class,'css-1k0rgcj-indicatorContainer')]"))
            .name("Operating Model Drop Down")
            .build();

    private final Locator operatingModelTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='Operating Model']/..//input"))
            .name("Operating Model Txt Box")
            .build();

    private final Locator cityDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='City']/..//div[contains(@class,'css-19bb58m')]"))
            .name("City Drop Down")
            .build();

    private final Locator cityTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='City']/..//input"))
            .name("City Txt Box")
            .build();

    private final Locator contractTypeDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='Contract Type']/..//div[contains(@class,'css-19bb58m')]"))
            .name("Contract Type Drop Down")
            .build();

    private final Locator contractTypeTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='Contract Type']/..//input"))
            .name("Contract Type Txt Box")
            .build();

    private final Locator revenueAssuranceDrpDown = Locator.buildLocator()
            .web(xpath("//p[text()='Revenue Assurance Type']/..//input"))
            .name("Revenue Assurance Type Drop Down")
            .build();

    private final Locator revenueAssuranceTypeTxtBox = Locator.buildLocator()
            .web(xpath("//p[text()='Revenue Assurance Type']/..//input"))
            .name("Revenue Assurance Type Txt Box")
            .build();


    private final Locator bidSubmissionDateInput = Locator.buildLocator()
            .web(xpath("//input[contains(@id,'bidSubmissionDate')]"))
            .name("Bid Submission Date Input")
            .build();

    public final Locator dateSelector(String day){
        return Locator.buildLocator()
                .web(xpath(String.format("//div[contains(@class, 'react-datepicker__day') and contains(text(),'%s')]",day)))
                .name("Date Selector")
                .build();
    }

    private final Locator  estimateMobilizationDateInput = Locator.buildLocator()
            .web(xpath("//input[contains(@id,'estimateMobilizationDate')]"))
            .name("Estimate Mobilization Date Input")
            .build();

    private final Locator customDrpDown = Locator.buildLocator()
            .web(cssSelector("span.css-1u9des2-indicatorSeparator"))
            .name("Custom Drp Down")
            .build();

    private final Locator createdSuccessToaster =  Locator.buildLocator()
            .web(xpath("//div[contains(text(),'Created Successfully')]"))
            .name("Created Successfully Toaster")
            .build();

    private final Locator dateNextNav = Locator.buildLocator()
            .web(cssSelector("button[aria-label='Next Month']"))
            .name("Date Next Nav")
            .build();

    private final Locator gasCostTxtBox = Locator.buildLocator()
            .web(xpath("//p[contains(text(),'Gas')]/../..//input[contains(@class,'css-1x5jdmq')]"))
            .name("Gas/Fuel Cost % (of Revenue) Txt Box")
            .build();

    private final Locator yearOnYearTxtBox = Locator.buildLocator()
            .web(xpath("//p[contains(text(),'Year')]/../..//input[contains(@class,'css-1x5jdmq')]"))
            .name("Year on Year % Change in Selling Price Txt Box")
            .build();

    private final Locator validateAPLBtn = Locator.buildLocator()
            .web(cssSelector("div.js-end :nth-child(1)"))
            .name("Validate APL Button")
            .build();

    private final Locator saveSectionDataBtn = Locator.buildLocator()
            .web(cssSelector("div.js-end :nth-child(2)"))
            .name("Save Section Data Btn")
            .build();

}
