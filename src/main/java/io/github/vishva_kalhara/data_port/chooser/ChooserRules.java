package io.github.vishva_kalhara.data_port.chooser;

/**
 * Defines the rules for verifying a chosen file or directory path.
 * Implementations of this interface should provide logic to validate
 * whether a given path meets the necessary criteria.
 *
 * @author Wishva Kalhara
 */
public interface ChooserRules {

    /**
     * Verifies whether the specified path is valid according to the implemented rules.
     *
     * @param path The file or directory path to be verified.
     * @throws ChooserException If the path does not meet the required criteria.
     */
    void verify(String path) throws ChooserException;
}
