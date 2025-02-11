

package org.cbs.config.ui.mobile.device;

import static org.cbs.enums.ApplicationType.NATIVE;

import org.cbs.enums.ApplicationType;
import org.cbs.enums.Browser;
import lombok.Data;

/**
 * Application specific settings.
 *
 * @author Rahul Saini
 * @since 13-Dec-2024
 */
@Data
public class ApplicationSetting {
    private String  baseUrl;
    private Browser browser;
    private String  bundleId;
    private int             chromeDriverPort;
    private boolean         external;
    private int             installTimeout = 30;
    private String          path;
    private ApplicationType type           = NATIVE;
    private String          waitActivity;
    private int             waitTimeout    = 30;
}
