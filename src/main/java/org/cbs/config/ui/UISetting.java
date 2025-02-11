package org.cbs.config.ui;

import static org.cbs.utils.SettingUtils.getSetting;

import java.util.Map;

import org.cbs.config.api.ApiSetting;
import org.cbs.config.ui.mobile.MobileSetting;
import org.cbs.config.ui.web.WebSetting;
import lombok.Data;
import org.cbs.utils.SettingUtils;

/**
 * @author Rahul Saini
 * @since 17-Dec-2024
 */
@Data
public class UISetting {
    private DelaySetting               delay      = new DelaySetting ();
    private LogSetting                 logging    = new LogSetting ();
    private Map<String, MobileSetting> mobile;
    private ScreenshotSetting          screenshot = new ScreenshotSetting ();
    private TimeoutSetting             timeout    = new TimeoutSetting ();
    private Map<String, WebSetting>    web;
    private Map<String, ApiSetting>    api;

    /**
     * Get Mobile settings.
     *
     * @param key config key for mobile
     *
     * @return the {@link MobileSetting}
     */
    public MobileSetting getMobileSetting (final String key) {
        return getSetting (this.mobile, key);
    }

    /**
     * Gets the web setting.
     *
     * @param key the config key for Web
     *
     * @return the {@link WebSetting}
     */
    public WebSetting getWebSetting (final String key) {
        return getSetting (this.web, key);
    }

    /**
     * Gets the service setting.
     *
     * @param key the config key for Web
     *
     * @return the {@link ApiSetting}
     */
    public ApiSetting getApiSetting (final String key) {
        return SettingUtils.getSetting (this.api, key);
    }
}
