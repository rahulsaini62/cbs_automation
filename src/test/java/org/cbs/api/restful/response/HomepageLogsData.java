package org.cbs.api.restful.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomepageLogsData {
    private List<HomepageLogs> list;
}
