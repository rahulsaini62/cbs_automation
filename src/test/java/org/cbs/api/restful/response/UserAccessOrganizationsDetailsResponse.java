package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserAccessOrganizationsDetailsResponse {
    private int statusCode;
    private boolean success;
    private String message;
    private UserAccessOrganizationsDetailsData data;
}
