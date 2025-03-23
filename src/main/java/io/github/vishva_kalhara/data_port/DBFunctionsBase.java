package io.github.vishva_kalhara.data_port;

import java.io.IOException;

/**
 * An abstract base class that implements the {@link DBFunctions} interface.
 * This class provides common functionality for managing database operations,
 * including backup, restore, create, and drop operations. It also provides
 * utility methods for executing system commands and handling database paths.
 *
 * @author Wishva Kalhara
 */
public abstract class DBFunctionsBase implements DBFunctions {

    protected DBCredentials credentials;
    protected String dumpPath;
    protected String exePath;

    /**
     * Constructs a {@code DBFunctionsBase} instance with the specified database credentials.
     *
     * @param credentials The credentials used to authenticate with the database.
     */
    public DBFunctionsBase(DBCredentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Sets the executable path for the database operations.
     *
     * @param exePath The path to the executable.
     * @return The current {@code DBFunctionsBase} instance.
     */
    public DBFunctionsBase setExePath(String exePath) {
        this.exePath = exePath;
        return this;
    }

    /**
     * Sets the dump path where the database backups will be stored.
     *
     * @param dumpPath The path to the database dump.
     * @return The current {@code DBFunctionsBase} instance.
     */
    public DBFunctionsBase setDumpPath(String dumpPath) {
        this.dumpPath = dumpPath;
        return this;
    }

    /**
     * Executes a system command and waits for it to complete.
     *
     * @param exec The command to execute.
     * @return {@code true} if the command was successful (exit code 0), {@code false} otherwise.
     * @throws IOException If an I/O error occurs during execution.
     * @throws InterruptedException If the execution is interrupted.
     * @throws DataPortException If the execution is interrupted.
     */
    protected final boolean execute(String exec) throws IOException, InterruptedException, DataPortException {

        Process process = Runtime.getRuntime().exec(exec);
        int exitCode = process.waitFor();

        return exitCode == 0;
    }

    /**
     * Drops, creates, and restores the database from a specified backup file.
     * This method ensures the database is first dropped and created before the restore process.
     *
     * @param backupFilePath The path to the backup file to restore.
     * @return {@code true} if the operations (drop, create, restore) were successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the operations.
     * @throws InterruptedException If the operations are interrupted.
     * @throws DataPortException If the operations are interrupted.
     */
    protected boolean override(String backupFilePath) throws IOException, InterruptedException, DataPortException {

        boolean isDropped = this.drop();
        if (!isDropped) return false;

        boolean isCreated = this.create();
        if (!isCreated) return false;

        return this.restore(backupFilePath);
    }
}
