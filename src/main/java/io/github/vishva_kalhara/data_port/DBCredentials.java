package io.github.vishva_kalhara.data_port;

/**
 * Represents the database credentials required for authenticating with a database.
 * This class holds the username, password, and database name necessary to connect
 * to a database.
 *
 * @author Wishva Kalhara
 */
public class DBCredentials {

    private final String username;
    private final String password;
    private final String dbName;

    /**
     * Constructs a {@code DBCredentials} instance with the specified username, password, and database name.
     *
     * @param username The username used for database authentication.
     * @param password The password associated with the username.
     * @param dbName The name of the database to connect to.
     */
    public DBCredentials(String username, String password, String dbName) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    /**
     * Gets the name of the database.
     *
     * @return The database name.
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Gets the password used for database authentication.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username used for database authentication.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }
}
