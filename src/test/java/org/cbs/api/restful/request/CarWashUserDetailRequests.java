package org.cbs.api.restful.request;

import java.util.Map;

import static org.cbs.manager.ParallelSession.getSession;

import org.cbs.api.restful.AdminEndPoint;
import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

public class CarWashUserDetailRequests {
    public static ApiRequest getCarWashUserDetailRequest (Map<String, String> header) {
        return ApiRequest.createRequest ()
            .method (RequestMethod.GET)
            .headers (header)
            .path (AdminEndPoint.CARWASH_USER_DETAIL + "/" + getSession ().getSharedData (
                "userType") + "/" + getSession ().getSharedData ("userId"))
            .create ();
    }
}
