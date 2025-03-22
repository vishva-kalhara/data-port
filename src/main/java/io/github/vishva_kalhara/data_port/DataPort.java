package io.github.vishva_kalhara.data_port;

import io.github.vishva_kalhara.data_port.util.DBObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class DataPort {

    private final String username;
    private final String password;
    private final String dbName;
    private final String binPath;

    private final HashSet<DBObject> dbObjects;

    public DataPort(String username, String password, String dbName, String binPath){
        this.username = username;
        this.password = password;
        this.dbName = dbName;
        this.binPath = binPath;
        this.dbObjects = new HashSet<>();
    }

    public DataPort objects(DBObject... objs){
        this.dbObjects.addAll(Arrays.asList(objs));

        return this;
    }

    private boolean execute(String exec) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(exec);
        int exitCode = process.waitFor();

        return exitCode == 0;
    }

    public boolean backup(String backupPath) throws IOException, InterruptedException {

        String BackUpName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        return this.backup(backupPath, BackUpName);
    }

    public boolean backup(String backupPath, String fileName) throws IOException, InterruptedException {

        String toSavePath = backupPath + "/backup_" + fileName + ".sql";

        String exec = binPath + " -u" + username + " -p" + password + " --add-drop-database -B " + dbName +  " --routines --triggers --events -r \"" + toSavePath + "\"";
        return this.execute(exec);
    }

    public boolean drop() throws IOException, InterruptedException {

        String exec = binPath + " -u" + username + " -p" + password + " -e \"DROP DATABASE " + dbName + "\"";
        return this.execute(exec);
    }

    public boolean create() throws IOException, InterruptedException {

        String exec = binPath + " -u" + username + " -p" + password + " -e \"CREATE DATABASE " + dbName + "\"";
        return this.execute(exec);
    }

    public boolean restore(String backupFilePath) throws IOException, InterruptedException {

        String newMySqlPath = "\"" + binPath + "\"";

        String exec = "cmd.exe /c \"" + newMySqlPath + " -u" + username + " -p" + password + " " + dbName + " < \"" + backupFilePath + "\"\"";
        return this.execute(exec);
    }

    public boolean override(String backupFilePath) throws IOException, InterruptedException {

        boolean isDropped = this.drop();
        if(!isDropped) return false;

        boolean isCreated = this.create();
        if(!isCreated) return false;

        return this.restore(backupFilePath);
    }
}
