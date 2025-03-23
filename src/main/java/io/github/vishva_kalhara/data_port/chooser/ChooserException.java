package io.github.vishva_kalhara.data_port.chooser;

/**
 * Represents an exception that is thrown when a chosen file or directory
 * path does not meet the required criteria.
 * <p>
 * This exception is used in conjunction with {@link ChooserRules} to
 * enforce validation rules on selected paths.
 * </p>
 *
 * @author Wishva Kalhara
 */
public class ChooserException extends Exception {

    /**
     * Constructs a new {@code ChooserException} with the specified detail message.
     *
     * @param message The detail message describing the reason for the exception.
     */
    public ChooserException(String message) {
        super(message);
    }
}
