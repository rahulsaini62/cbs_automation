package org.cbs.parser;

import static org.cbs.manager.ParallelSession.getSession;

import org.cbs.enums.TestDataSource;

/**
 * Test Data factory.
 *
 * @author Rahul Saini
 * @since 28-Dec-2024
 */
public final class DataFactory {
    /**
     * Get Test data parser.
     *
     * @return {@link IDataParser} instance.
     */
    public static IDataParser getParser () {
        final var setting = getSession ().getSetting ()
            .getData ();
        if (setting.getType () == TestDataSource.EXCEL) {
            return new ExcelParser ();
        }
        return null;
    }

    private DataFactory () {
        // Utility class.
    }
}
