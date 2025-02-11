package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomepageLogs {
    private String id;
    private String date_time;
    private int    activity_type;
    private String action_description;
    private String description;
}