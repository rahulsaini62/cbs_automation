package org.cbs.api.restful.request;

import java.util.Map;

import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;
import org.cbs.api.restful.AdminEndPoint;

public class HomepageRequests {
    public static ApiRequest getHomePageLogsRequest (Map<String, String> header, Map<String, String> queryParams) {
        return ApiRequest.createRequest ()
            .method (RequestMethod.GET)
            .headers (header)
            .queryParams (queryParams)
            .path (AdminEndPoint.HOME_PAGE_LOGS)
            .create ();
    }
}
