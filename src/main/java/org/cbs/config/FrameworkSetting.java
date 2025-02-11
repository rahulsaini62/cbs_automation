package org.cbs.config;

import static org.cbs.enums.Message.CONFIG_KEY_NOT_FOUND;
import static org.cbs.enums.Message.NO_API_SETTINGS_FOUND;
import static org.cbs.utils.ErrorHandler.throwError;
import static org.cbs.utils.Validator.requireNonNull;
import static java.lang.String.join;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.Map;

import org.cbs.config.api.ApiSetting;
import org.cbs.config.ui.UISetting;
import lombok.Data;
import org.apache.logging.log4j.Logger;

/**
 * Framework setting.
 *
 * @author Rahul Saini
 * @since 17-Dec-2024
 */
@Data
public class FrameworkSetting {
    private static final Logger LOGGER = getLogger ();

    private Map<String, ApiSetting> api;
    private TestDataSetting         data = new TestDataSetting ();
    private String                  listenersPackage;
    private UISetting               ui;

    /**
     * Get API setting.
     *
     * @param key API config key
     *
     * @return {@link ApiSetting} instance
     */
    public ApiSetting getApiSetting (final String key) {
        LOGGER.traceEntry ("Key: {}", key);
        if (!this.api.containsKey (key)) {
            final var keys = join (", ", this.api.keySet ());
            throwError (CONFIG_KEY_NOT_FOUND, key, keys);
        }
        return LOGGER.traceExit (requireNonNull (this.api.get (key), NO_API_SETTINGS_FOUND, key));
    }
}
