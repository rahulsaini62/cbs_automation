package org.cbs.api.restful.request;

import org.cbs.api.restful.AdminEndPoint;
import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

import java.util.Map;

public class UserAccessGroupRequests {
    public static ApiRequest getUserAccessGroupListingDetails (Map<String, String> header, Map<String, String> queryParams) {
        return ApiRequest.createRequest ()
                .method (RequestMethod.GET)
                .headers (header)
                .queryParams (queryParams)
                .path (AdminEndPoint.USER_ACCESS)
                .create ();
    }
    public static ApiRequest getUserAccessOrganizationsDetails(Map<String, String> header, Map<String, String> queryParams){
        return ApiRequest.createRequest ()
                .method (RequestMethod.GET)
                .headers (header)
                .queryParams (queryParams)
                .path (AdminEndPoint.USER_ACCESS_ORGANIZATION)
                .create ();

    }
}
