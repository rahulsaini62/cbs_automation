package org.cbs.data.admin.props;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class OrganizationProps {
    private String organizationPageTitle;
    private String transferOwnershipPageTitle;
    private List<String> transferHeaderList;
    private String headersCount;
    private String selectedButton;
    private String selectButton;
    private String searchPlaceholder;
    private String ownershipTransferredMsg;
    private String selectBtnBackgroundColorCode;
    private String selectedBtnBackgroundColorCode;
    private String transferOwnershipUserType;
}
