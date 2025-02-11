package org.cbs.api.restful.response;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserAccessGroupListingDetailsResponse {
        private int statusCode;
        private boolean success;
        private String message;
        private UserAccessGroupListingDetailsData data;

}

