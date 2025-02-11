package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarwashUserList {
    private String user_id;
    private String name;
    private String email;
    private String user_type;
    private String status;
    private String createdDate;
    private String organizationId;
    private String organizationName;
    private String organizationStatus;
}