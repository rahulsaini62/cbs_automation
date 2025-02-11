package org.cbs.api.restful.request;

import org.cbs.api.restful.AdminEndPoint;
import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

import java.util.Map;

public class LogoutRequests {
    public static ApiRequest getLogout(final Map<String,String> header)
    {
        return ApiRequest.createRequest()
                .headers (header)
                .method (RequestMethod.POST)
                .path (AdminEndPoint.LOGOUT)
                .create();
    }
}
