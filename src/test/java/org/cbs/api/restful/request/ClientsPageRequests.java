package org.cbs.api.restful.request;

import org.cbs.api.restful.AdminEndPoint;
import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

import java.util.Map;

public class ClientsPageRequests {
    public static ApiRequest getClientsPageDetails(Map<String, String> header, Map<String, String> queryParams){
        return ApiRequest.createRequest ()
                .method (RequestMethod.GET)
                .headers (header)
                .queryParams (queryParams)
                .path (AdminEndPoint.CLIENTS_PAGE)
                .create ();

    }
}
