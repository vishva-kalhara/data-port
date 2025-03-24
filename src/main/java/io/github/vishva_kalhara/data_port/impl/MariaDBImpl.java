package io.github.vishva_kalhara.data_port.impl;

import io.github.vishva_kalhara.data_port.DBCredentials;
import io.github.vishva_kalhara.data_port.DBFunctionsBase;
import io.github.vishva_kalhara.data_port.DataPortException;

/**
 * Implementation of the {@link DBFunctionsBase} class for MariaDB operations.
 * This class provides concrete implementations for database backup, restore,
 * drop, and create operations using MySQL-specific commands and credentials.
 * <p>
 * It also includes enhanced error handling with {@link DataPortException} to ensure proper validation
 * of required paths and files before executing any database operations.
 * </p>
 *
 * @author Wishva Kalhara
 */
public class MariaDBImpl extends MySQLImpl{
    /**
     * Constructs a {@code MySQLImpl} instance with the specified database credentials.
     *
     * @param credentials The credentials used to authenticate with the MySQL database.
     */
    public MariaDBImpl(DBCredentials credentials) {
        super(credentials);
    }
}
