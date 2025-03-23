package io.github.vishva_kalhara.data_port.impl;

import io.github.vishva_kalhara.data_port.DBCredentials;
import io.github.vishva_kalhara.data_port.DBFunctionsBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySQLImpl extends DBFunctionsBase {

    public MySQLImpl(DBCredentials credentials, String binPath) {
        super(credentials, binPath);
    }

    @Override
    public boolean backup(String backupPath) throws IOException, InterruptedException {

        String BackUpName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        return this.backup(backupPath, BackUpName);
    }

    @Override
    public boolean backup(String backupPath, String fileName) throws IOException, InterruptedException {

        String toSavePath = backupPath + "/backup_" + fileName + ".sql";

        String exec = binPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " --add-drop-database -B " + credentials.getDbName() +  " --routines --triggers --events -r \"" + toSavePath + "\"";
        return super.execute(exec);
    }

    @Override
    public boolean drop() throws IOException, InterruptedException {

        String exec = binPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " -e \"DROP DATABASE " + credentials.getDbName() + "\"";
        return super.execute(exec);
    }

    @Override
    public boolean create() throws IOException, InterruptedException {

        String exec = binPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " -e \"CREATE DATABASE " + credentials.getDbName() + "\"";
        return super.execute(exec);
    }

    @Override
    public boolean restore(String backupFilePath) throws IOException, InterruptedException {

        String newMySqlPath = "\"" + binPath + "\"";

        String exec = "cmd.exe /c \"" + newMySqlPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " " + credentials.getDbName() + " < \"" + backupFilePath + "\"\"";
        return super.execute(exec);
    }
}
