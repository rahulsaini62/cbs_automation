package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarwashUserDetail {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone_number;
    private String userType;
    private String clientType;
    private String status;
}