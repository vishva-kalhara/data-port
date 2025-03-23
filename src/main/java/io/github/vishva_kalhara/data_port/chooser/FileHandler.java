package io.github.vishva_kalhara.data_port.chooser;

import javax.swing.*;
import java.awt.*;

/**
 * Provides a file chooser utility for selecting files or directories.
 * This class uses {@link JFileChooser} to allow users to choose files or directories
 * based on the specified selection mode.
 *
 * @author Wishva Kalhara
 */
public class FileHandler {

    private final Component parent;
    private final JFileChooser fileChooser;

    /**
     * Constructs a {@code FileHandler} with the specified parent component.
     *
     * @param parent The parent component for the file chooser dialog.
     */
    public FileHandler(Component parent){
        this.parent = parent;
        this.fileChooser = new JFileChooser();
    }

    /**
     * Opens the file chooser dialog with the default selection mode
     * ({@link ChooseType#FILES_AND_DIRECTORIES}).
     *
     * @return The selected file or directory path as a string, or {@code null} if no selection was made.
     */
    public String choose(){

        return this.choose(ChooseType.FILES_AND_DIRECTORIES);
    }

    /**
     * Opens the file chooser dialog with the specified selection mode.
     *
     * @param type The type of selection allowed (files, directories, or both).
     * @return The selected file or directory path as a string, or {@code null} if no selection was made.
     */
    public String choose(ChooseType type){

        fileChooser.setFileSelectionMode(type.getValue());
        return this.choose(fileChooser);
    }

    /**
     * Opens the file chooser dialog with the specified selection mode and applies validation rules.
     *
     * @param type The type of selection allowed (files, directories, or both).
     * @param rules The validation rules to be applied on the selected path.
     * @return The selected file or directory path as a string, or {@code null} if no selection was made.
     * @throws ChooserException If the selected path does not meet the validation rules.
     */
    public String choose(ChooseType type, ChooserRules rules) throws ChooserException {

        fileChooser.setFileSelectionMode(type.getValue());

        rules.verify("");
        return this.choose(fileChooser);
    }

    /**
     * Displays the file chooser dialog and returns the selected path.
     *
     * @param jFileChooser The {@code JFileChooser} instance.
     * @return The selected file or directory path as a string, or {@code null} if no selection was made.
     */
    private String choose(JFileChooser jFileChooser){

        int exitState = jFileChooser.showOpenDialog(this.parent);

        if (exitState == JFileChooser.APPROVE_OPTION) {
            String path = jFileChooser.getSelectedFile().getAbsolutePath();
            path = path.replace('\\', '/');
            return path;
        }

        return null;
    }
}
