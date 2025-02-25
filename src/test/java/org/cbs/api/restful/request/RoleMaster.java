package org.cbs.api.restful.request;

import org.cbs.builders.ApiRequest;
import org.cbs.enums.RequestMethod;

import java.util.Map;

public class RoleMaster {

    public static ApiRequest getRoleMasterLogsRequest (Map<String, String> header) {
        return ApiRequest.createRequest ()
                .method (RequestMethod.GET)
                .headers (header)
                .path ("roles")
                .create ();
    }

}
