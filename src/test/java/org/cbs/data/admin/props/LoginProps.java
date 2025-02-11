package org.cbs.data.admin.props;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginProps {
    private String pageUrl;
    private String pageHeading;
    private String pageSubHeading;
    private String page;
}
