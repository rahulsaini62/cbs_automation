package org.cbs.api.restful.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class ClientsPageResponse {
    private int statusCode;
    private boolean success;
    private String message;
    private ClientsPageData data;
}
