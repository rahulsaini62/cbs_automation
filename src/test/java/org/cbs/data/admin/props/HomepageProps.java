package org.cbs.data.admin.props;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomepageProps {
    private String pageUrl;
    private String breadcrumb;
    private String pageHeading;
}
