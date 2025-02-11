package org.cbs.data.admin.props;


import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CreateUserAccessGroupProps {
    private String headingTxt;
    private String groupNamePlaceTxt;
    private String userGroupView;
    private String searchPlaceTxt;
    private List<String> breadcrumbTxt;
    private List<String> tableHeading;


}