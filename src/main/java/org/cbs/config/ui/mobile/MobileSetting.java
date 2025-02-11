

package org.cbs.config.ui.mobile;

import org.cbs.config.ui.mobile.device.DeviceSetting;
import org.cbs.config.ui.mobile.server.ServerSetting;
import lombok.Data;

/**
 * Mobile settings.
 *
 * @author Rahul Saini
 * @since 06-Dec-2024
 */
@Data
public class MobileSetting {
    private DeviceSetting device = new DeviceSetting ();
    private ServerSetting server = new ServerSetting ();
}
