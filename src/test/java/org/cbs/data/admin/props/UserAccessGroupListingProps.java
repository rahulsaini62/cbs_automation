package org.cbs.data.admin.props;


import lombok.Data;

import java.util.List;

@Data
public class UserAccessGroupListingProps {
    private String pageUrl;
    private String breadcrumb;
    private String pageHeading;
    private String deactivateUserAccessGroupModalText;
    private List tableHeader;
    private String searchLabel;
    private List buttonIconsLabels;
    private String noResultFoundText;
    private String nextNavLabel;
    private String previousNavLabel;
    private String rowsPerPageLabel;
    private Integer searchMinCharLimit;
    private String filterCheckboxTitle;
    private String filterCheckboxResetLabel;
    private List filterCheckboxWrapperLabels;
    private List filterCheckboxBottomWrapperLabels;
    private String moduleSelectQuivioUserManagementText;
    private String statusSelectActiveText;
    private String statusSelectInactiveText;
    private String deactivateModalTitleText;
    private String deactivateModalSubtitleText;
    private String deactivateModalPlaceHolderText;
    private List deactivateModalButtonAreaTexts;
    private String deactivateSuccessMessage;
    private String activateModalTitleText;
    private String activateModalSubtitleText;
    private String activateModalPlaceHolderText;
    private List activateModalButtonAreaTexts;
    private String activateSuccessMessage;
    private String activateNavText;
    private String deactivateNavText;

}

