package org.cbs.api.restful.request;

import java.util.Map;

import org.cbs.api.restful.AdminEndPoint;
import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

public class CarWashUserListRequests {
    public static ApiRequest getCarWashUserListRequest (Map<String, String> header, Map<String, String> queryParams) {
        return ApiRequest.createRequest ()
            .method (RequestMethod.GET)
            .headers (header)
            .queryParams (queryParams)
            .path (AdminEndPoint.CARWASH_USER_LIST)
            .create ();
    }
}
