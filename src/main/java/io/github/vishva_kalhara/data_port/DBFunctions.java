package io.github.vishva_kalhara.data_port;

import java.io.IOException;

public interface DBFunctions {

    boolean backup(String backupPath) throws IOException, InterruptedException;

    boolean backup(String backupPath, String fileName) throws IOException, InterruptedException;

    boolean drop() throws IOException, InterruptedException;

    boolean create() throws IOException, InterruptedException;

    boolean restore(String backupFilePath) throws IOException, InterruptedException;
}
