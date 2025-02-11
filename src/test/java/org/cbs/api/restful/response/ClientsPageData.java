package org.cbs.api.restful.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString

public class ClientsPageData {
    private List<ClientsPageData> list;
    private String name;
    private String email;
}
