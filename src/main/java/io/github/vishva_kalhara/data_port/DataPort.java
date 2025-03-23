package io.github.vishva_kalhara.data_port;

import io.github.vishva_kalhara.data_port.impl.MySQLImpl;

/**
 * The {@code DataPort} class serves as a central access point for database operations.
 * It provides methods to interact with the database, such as backup, restore, create, and drop operations.
 * Specifically, this class allows access to a {@link MySQLImpl} instance, which implements the database operations
 * for MySQL databases.
 * <p>
 * It is initialized with a set of {@link DBCredentials} that will be used for the authentication and operations
 * on the target database.
 * </p>
 *
 * @author Vishva Kalhara
 */
public class DataPort {

    private final DBCredentials credentials;

    /**
     * Constructs a new {@code DataPort} with the specified database credentials.
     *
     * @param credentials The database credentials containing the username, password, and database name.
     */
    public DataPort(DBCredentials credentials){
        this.credentials = credentials;
    }

    /**
     * Returns an instance of {@link MySQLImpl} for performing MySQL database operations.
     *
     * @return A {@link MySQLImpl} object that allows MySQL-specific database operations such as backup, restore, etc.
     */
    public MySQLImpl mySql(){
        return new MySQLImpl(this.credentials);
    }
}
