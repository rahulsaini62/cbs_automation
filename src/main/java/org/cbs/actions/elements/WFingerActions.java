package org.cbs.actions.elements;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.cbs.enums.ListenerType.FINGER_ACTION;
import static org.cbs.enums.PlatformType.WEB;
import static org.cbs.manager.ParallelSession.getSession;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.cbs.actions.interfaces.elements.IFingerActions;
import org.cbs.actions.interfaces.listeners.elements.IFingerActionsListener;
import org.cbs.builders.Locator;
import org.cbs.config.ui.mobile.device.SwipeSetting;
import org.cbs.enums.SwipeDirection;

public class WFingerActions extends WElementActions implements IFingerActions {
    private static final Logger LOGGER = getLogger ();

    /**
     * Perform single finger actions on element
     *
     * @param element Locator of the element
     *
     * @return Finger actions instance
     */
    public static IFingerActions withFinger (final WebElement element) {
        return new WFingerActions (element);
    }

    /**
     * Perform single finger actions on element
     *
     * @return Finger actions instance
     */
    public static IFingerActions withFinger () {
        return new FingerActions ();
    }

    private final IFingerActionsListener listener;
    private       SwipeSetting           swipeSetting;

    WFingerActions () {
        this (null);
    }

    WFingerActions (final WebElement element) {
        super (element);
        this.listener = getSession ().getListener (FINGER_ACTION);
        if (getSession ().getPlatformType () != WEB) {
            this.swipeSetting = getSession ().getMobileSetting ()
                .getDevice ()
                .getSwipe ();
        }
    }

    /**
     * Drag one element to another element.
     *
     * @param destination Target element
     */
    @Override
    public void dragTo (final Locator destination) {

    }

    /**
     * Swipe on the Mobile screen starting from center of the screen to the direction mentioned
     *
     * @param direction Direction to swipe in.
     */
    @Override
    public void swipe (final SwipeDirection direction) {

    }

    /**
     * Swipe until element is displayed in the mentioned direction.
     *
     * @param direction Direction to swipe in
     */
    @Override
    public void swipeTill (final SwipeDirection direction) {

    }

    /**
     * Taps on an element.
     */
    @Override
    public void tap () {

    }
}
