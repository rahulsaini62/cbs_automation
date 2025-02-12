package org.cbs.data.admin.props;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class cbsMasterProps {

    private List<String> serviceTypeMasterTableColumn;
    private String roleMasterTitle;
    private List<String> roleMasterColumnTxt;
    private String createRoleTxt;
    private List<String> createRolePopupBtnWrapperTxt;
    private String createRolePopupTitle;
    private String roleNameTxt;
    private String createRoleTxtBoxPlaceholderTxt;



}
