package io.github.vishva_kalhara.data_port.chooser;

/**
 * Represents the different types of file chooser modes.
 * This enum is used to specify whether the chooser should allow
 * selection of files only, directories only, or both files and directories.
 * <p>
 * Each enum constant is associated with an integer value.
 * </p>
 *
 * @author Wishva Kalhara
 */
public enum ChooseType {

    /**
     * Allows selection of files only.
     */
    FILES_ONLY(0),

    /**
     * Allows selection of directories only.
     */
    DIRECTORIES_ONLY(1),

    /**
     * Allows selection of both files and directories.
     */
    FILES_AND_DIRECTORIES(2);

    private final int value;

    /**
     * Constructs a {@code ChooseType} with the specified integer value.
     *
     * @param value The integer representation of the chooser type.
     */
    ChooseType(int value){
        this.value = value;
    }

    /**
     * Returns the integer value associated with the chooser type.
     *
     * @return The integer value of the chooser type.
     */
    public int getValue(){
        return this.value;
    }
}
