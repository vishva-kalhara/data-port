package io.github.vishva_kalhara.data_port.impl;

import io.github.vishva_kalhara.data_port.DBCredentials;
import io.github.vishva_kalhara.data_port.DBFunctionsBase;
import io.github.vishva_kalhara.data_port.DataPortException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of the {@link DBFunctionsBase} class for MySQL database operations.
 * This class provides concrete implementations for database backup, restore,
 * drop, and create operations using MySQL-specific commands and credentials.
 * <p>
 * It also includes enhanced error handling with {@link DataPortException} to ensure proper validation
 * of required paths and files before executing any database operations.
 * </p>
 *
 * @author Wishva Kalhara
 */
public class MySQLImpl extends DBFunctionsBase {

    /**
     * Constructs a {@code MySQLImpl} instance with the specified database credentials.
     *
     * @param credentials The credentials used to authenticate with the MySQL database.
     */
    public MySQLImpl(DBCredentials credentials) {
        super(credentials);
    }

    /**
     * Backs up the MySQL database to a file in the specified backup path. The backup file name is generated
     * using the current date and time in the format "yyyy-MM-dd_HH-mm-ss".
     *
     * @param backupPath The path where the backup file will be stored.
     * @return {@code true} if the backup operation is successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the backup process.
     * @throws InterruptedException If the backup operation is interrupted.
     * @throws DataPortException If the dump file path is not set.
     */
    @Override
    public boolean backup(String backupPath) throws IOException, InterruptedException, DataPortException {

        String BackUpName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        return this.backup(backupPath, BackUpName);
    }

    /**
     * Backs up the MySQL database to a file in the specified backup path with the given file name.
     *
     * @param backupPath The path where the backup file will be stored.
     * @param fileName The name of the backup file.
     * @return {@code true} if the backup operation is successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the backup process.
     * @throws InterruptedException If the backup operation is interrupted.
     * @throws DataPortException If the dump file path is not set.
     */
    @Override
    public boolean backup(String backupPath, String fileName) throws IOException, InterruptedException, DataPortException {

        if(super.dumpPath == null){
            throw new DataPortException("Dump file is null");
        }

        String toSavePath = backupPath + "/backup_" + fileName + ".sql";

        String exec = super.dumpPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " --add-drop-database -B " + credentials.getDbName() +  " --routines --triggers --events -r \"" + toSavePath + "\"";
        return super.execute(exec);
    }

    /**
     * Drops the MySQL database specified in the credentials.
     *
     * @return {@code true} if the database drop operation is successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the drop operation.
     * @throws InterruptedException If the drop operation is interrupted.
     * @throws DataPortException If the executable file path is not set.
     */
    @Override
    public boolean drop() throws IOException, InterruptedException, DataPortException {

        if(super.exePath == null){
            throw new DataPortException("Exe file is null");
        }

        String exec = exePath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " -e \"DROP DATABASE " + credentials.getDbName() + "\"";
        return super.execute(exec);
    }

    /**
     * Creates the MySQL database specified in the credentials.
     *
     * @return {@code true} if the database creation operation is successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the creation process.
     * @throws InterruptedException If the creation operation is interrupted.
     * @throws DataPortException If the executable file path is not set.
     */
    @Override
    public boolean create() throws IOException, InterruptedException , DataPortException {

        if(super.exePath == null){
            throw new DataPortException("Exe file is null");
        }

        String exec = exePath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " -e \"CREATE DATABASE " + credentials.getDbName() + "\"";
        return super.execute(exec);
    }

    /**
     * Restores the MySQL database from a backup file.
     *
     * @param backupFilePath The path to the backup file.
     * @return {@code true} if the restore operation is successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the restore process.
     * @throws InterruptedException If the restore operation is interrupted.
     * @throws DataPortException If the executable file path is not set.
     */
    @Override
    public boolean restore(String backupFilePath) throws IOException, InterruptedException , DataPortException {

        if(super.exePath == null){
            throw new DataPortException("Exe file is null");
        }

        String newMySqlPath = "\"" + exePath + "\"";

        String exec = "cmd.exe /c \"" + newMySqlPath + " -u" + credentials.getUsername() + " -p" + credentials.getPassword() + " " + credentials.getDbName() + " < \"" + backupFilePath + "\"\"";
        return super.execute(exec);
    }
}
