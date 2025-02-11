package org.cbs.data.admin.props;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ClientsPageProps {
    private String       pageUrl;
    private String       breadcrumb;
    private String       pageHeading;
    private String       breadcrumbLink;
    private String       subTitle;
    private String       addNewUserPageHeading;
    private List<String> clientPageTableHeaderList;
    private String       firstPage;
    private String       secondPage;
    private String       clickOnLastNumber;
    private String       filterTitle;
    private String       orgName;
    private String       activeStatus;
    private String       inactiveStatus;
    private String       invitationSent;
    private String       userTypeOwner;
    private String       userTypeAdmin;
    private String searchPlaceTxt;
    private String noResultFoundText;
}
