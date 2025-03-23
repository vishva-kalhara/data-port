package io.github.vishva_kalhara.data_port;

import java.io.IOException;

/**
 * Defines the database management operations related to backup, restore, creation, and deletion.
 * Implementations of this interface should provide logic to perform these operations
 * on a database, such as backing up data, restoring from a backup, and managing the database state.
 *
 * @author Wishva Kalhara
 */
public interface DBFunctions {

    /**
     * Backs up the database to the specified path.
     *
     * @param backupPath The path where the backup will be stored.
     * @return {@code true} if the backup was successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the backup process.
     * @throws InterruptedException If the backup process is interrupted.
     * @throws DataPortException If the backup process is interrupted.
     */
    boolean backup(String backupPath) throws IOException, InterruptedException, DataPortException;

    /**
     * Backs up the database to the specified path with a custom file name.
     *
     * @param backupPath The path where the backup will be stored.
     * @param fileName The name of the backup file.
     * @return {@code true} if the backup was successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the backup process.
     * @throws InterruptedException If the backup process is interrupted.
     * @throws DataPortException If the backup process is interrupted.
     */
    boolean backup(String backupPath, String fileName) throws IOException, InterruptedException, DataPortException;

    /**
     * Drops (deletes) the database.
     *
     * @return {@code true} if the database was successfully dropped, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the drop process.
     * @throws InterruptedException If the drop process is interrupted.
     * @throws DataPortException If the drop process is interrupted.
     */
    boolean drop() throws IOException, InterruptedException, DataPortException;

    /**
     * Creates the database.
     *
     * @return {@code true} if the database was successfully created, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the creation process.
     * @throws InterruptedException If the creation process is interrupted.
     * @throws DataPortException If the creation process is interrupted.
     */
    boolean create() throws IOException, InterruptedException, DataPortException;

    /**
     * Restores the database from the specified backup file.
     *
     * @param backupFilePath The path to the backup file from which to restore.
     * @return {@code true} if the restore was successful, {@code false} otherwise.
     * @throws IOException If an I/O error occurs during the restore process.
     * @throws InterruptedException If the restore process is interrupted.
     * @throws DataPortException If the restore process is interrupted.
     */
    boolean restore(String backupFilePath) throws IOException, InterruptedException, DataPortException;
}
