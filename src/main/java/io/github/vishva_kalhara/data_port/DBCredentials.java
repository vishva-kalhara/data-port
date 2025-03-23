package io.github.vishva_kalhara.data_port;

public class DBCredentials {

    private final String username;
    private final String password;
    private final String dbName;

    public DBCredentials(String username, String password, String dbName) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
