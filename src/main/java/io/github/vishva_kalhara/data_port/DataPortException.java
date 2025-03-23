package io.github.vishva_kalhara.data_port;

/**
 * Custom exception class used for handling errors related to data port operations.
 * This exception is thrown when an error occurs during operations like backup, restore,
 * create, or drop database tasks, especially when required file paths or other dependencies are missing.
 * <p>
 * This class extends {@link Exception} and provides a way to convey specific error messages related
 * to data port tasks.
 * </p>
 *
 * @author Vishva Kalhara
 */
public class DataPortException extends Exception {

  /**
   * Constructs a new {@code DataPortException} with the specified detail message.
   *
   * @param message The detail message that explains the reason for the exception.
   */
  public DataPortException(String message) {
    super(message);
  }
}
