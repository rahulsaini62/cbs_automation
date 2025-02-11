package org.cbs.api.restful.response;

import lombok.Data;

@Data
public class LogoutResponse {
    private int              statusCode;
    private boolean          success;
    private String           message;
}
