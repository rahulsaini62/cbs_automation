package org.cbs.actions.device;

import static org.cbs.actions.CommonActions.performDriverAction;
import static org.cbs.enums.ListenerType.ANDROID_DEVICE_ACTION;
import static org.cbs.enums.Message.ACTION_NOT_SUPPORTED_ON_PLATFORM;
import static org.cbs.enums.PlatformType.ANDROID;
import static org.cbs.manager.ParallelSession.getSession;
import static org.cbs.utils.ErrorHandler.throwError;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.cbs.actions.interfaces.device.IAndroidDeviceActions;
import org.cbs.actions.interfaces.listeners.device.IAndroidDeviceActionsListener;
import org.apache.logging.log4j.Logger;

/**
 * Handles all Android device specific actions.
 *
 * @author Rahul Saini
 * @since 06-Jun-2024
 */
public class AndroidDeviceActions extends DeviceActions implements IAndroidDeviceActions {
    private static final IAndroidDeviceActions DEVICE_ACTIONS = new AndroidDeviceActions ();
    private static final Logger                LOGGER         = getLogger ();

    /**
     * Handles Android device specific actions.
     *
     * @return {@link IAndroidDeviceActions} instance
     */
    public static IAndroidDeviceActions onAndroidDevice () {
        return DEVICE_ACTIONS;
    }

    private final IAndroidDeviceActionsListener listener;

    private AndroidDeviceActions () {
        this.listener = getSession ().getListener (ANDROID_DEVICE_ACTION);
    }

    @Override
    public void pressKey (final AndroidKey key) {
        LOGGER.traceEntry ();
        final var platform = getSession ().getPlatformType ();
        if (platform != ANDROID) {
            throwError (ACTION_NOT_SUPPORTED_ON_PLATFORM, "Press key", platform);
        }
        LOGGER.info ("Pressing key [{}] on Android device...", key);
        ofNullable (this.listener).ifPresent (l -> l.onPressKey (key));
        performDriverAction ((AndroidDriver d) -> d.pressKey (new KeyEvent ().withKey (key)));
        LOGGER.traceExit ();
    }
}
