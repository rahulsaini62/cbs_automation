

package org.cbs.config.ui.mobile.server;

import org.cbs.enums.LogLevel;
import lombok.Data;

/**
 * Mobile logging settings.
 *
 * @author Rahul Saini
 * @since 21-Dec-2024
 */
@Data
public class LogSetting {
    private boolean  debugSpacing;
    private LogLevel level = LogLevel.INFO;
    private boolean  localTimezone;
    private boolean  timestamp;
}
