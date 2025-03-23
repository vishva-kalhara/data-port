package io.github.vishva_kalhara.data_port;

import java.io.IOException;

public abstract class DBFunctionsBase implements DBFunctions {

    protected DBCredentials credentials;
    protected String binPath;

    public DBFunctionsBase(DBCredentials credentials, String binPath){
        this.credentials = credentials;
        this.binPath = binPath;
    }

    protected final boolean execute(String exec) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(exec);
        int exitCode = process.waitFor();

        return exitCode == 0;
    }

    protected boolean override(String backupFilePath) throws IOException, InterruptedException {

        boolean isDropped = this.drop();
        if(!isDropped) return false;

        boolean isCreated = this.create();
        if(!isCreated) return false;

        return this.restore(backupFilePath);
    }
}
