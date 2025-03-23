package io.github.vishva_kalhara.data_port;

import io.github.vishva_kalhara.data_port.impl.MySQLImpl;

public class DataPort {

    private final DBCredentials credentials;
    private final String binPath;

    public DataPort(DBCredentials credentials, String binPath){
        this.credentials = credentials;
        this.binPath = binPath;
    }

    public MySQLImpl mySql(){
        return new MySQLImpl(this.credentials, this.binPath);
    }
}
