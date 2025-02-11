package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UserAccessGroupListingDetailsData {
        private List<UserAccessGroupListingDetailsData> list;
        private String group_id;
        private String group_name;
        private String status;
        private String keycloak_id;
        private String organization_count;
}

