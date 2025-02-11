

package org.cbs.actions.interfaces.api;

import org.cbs.builders.ApiResponse;

/**
 * Execute API
 *
 * @author Rahul Saini
 * @since 18-Dec-2024
 */
public interface IApiActions {
    /**
     * Execute API request
     *
     * @return {@link ApiResponse} from the executed request
     */
    ApiResponse execute ();
}
