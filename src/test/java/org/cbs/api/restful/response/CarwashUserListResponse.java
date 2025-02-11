package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarwashUserListResponse {
    private int              statusCode;
    private boolean          success;
    private String              message;
    private CarwashUserListData data;

}