package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UserAccessOrganizationsDetailsData {
    private List<UserAccessOrganizationsDetailsData> list;
    private String id;
    private String name;
    private UserAccessOrganizationCarWashOwnerData carwash_owner;  // Use the separate class here
    private int site_count;
    private int  total_items;



}