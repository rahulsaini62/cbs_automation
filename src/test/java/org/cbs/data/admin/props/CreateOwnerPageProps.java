package org.cbs.data.admin.props;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class CreateOwnerPageProps {
    private String pageUrl;
    private String breadcrumb;
    private String pageHeading;
    private String breadcrumbLink;
    private String subTitle;
    private String sectionTitle;
    private String firstNameLabel;
    private String lastNameLabel;
    private String emailLabel;
    private String phoneNumberLabel;
    private String cancelBtn;
    private String nextBtn;
    private String invalidEmailErrorMessage;
    private String minimumCharFirstNameErrorMsg;
    private String minimumCharLastNameErrorMsg;
    private String maximumCharFirstNameErrorMsg;
    private String maximumCharLastNameErrorMsg;
    private String invalidPhoneNumberErrorMessage;
    private String firstNamePlaceholder;
    private String lastNamePlaceholder;
    private String emailPlaceholder;
    private String phoneNumberPlaceholder;
    private String AddNewBtn;
    private String PlanManagement;
    private String SelectModules;
    private String MarketingAutomation;
    private String Reporting;
    private String SaveBtn;
    private String BackBtn;
    private String CancelChanges;
    private String CancelChangesMsg;
    private String ConfirmBtn;
    private String Stepper_1;
    private String Stepper_2;
    private String UserAddedTitle;
    private String UserAddedSuccessfulMsg;
    private String EmailExtension;
    private String EmptyPhoneNumberMsg;
    private String EmailAlertMsg;
    private String PhoneNumAlertMsg;
    private String ToolTipText;
}
