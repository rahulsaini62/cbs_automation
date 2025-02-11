

package org.cbs.config.ui.mobile.device;

import static org.cbs.enums.Speed.FAST;

import org.cbs.enums.Speed;
import lombok.Data;

/**
 * Swipe related settings
 *
 * @author Rahul Saini
 * @since 02-Dec-2024
 */
@Data
public class SwipeSetting {
    private int   distance           = 75;
    private int   maxSwipeUntilFound = 5;
    private Speed speed              = FAST;
}
