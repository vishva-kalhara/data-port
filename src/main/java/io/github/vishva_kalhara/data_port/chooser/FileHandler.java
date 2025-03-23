package io.github.vishva_kalhara.data_port.chooser;

import javax.swing.*;
import java.awt.*;

public class FileHandler {

    private final Component parent;
    private final JFileChooser fileChooser;

    public FileHandler(Component parent){
        this.parent = parent;
        this.fileChooser = new JFileChooser();
    }

    public String choose(){

        return this.choose(ChooseType.FILES_AND_DIRECTORIES);
    }

    public String choose(ChooseType type){

        fileChooser.setFileSelectionMode(type.getValue());
        return this.choose(fileChooser);
    }

    public String choose(ChooseType type, ChooserRules rules) throws ChooserException {

        fileChooser.setFileSelectionMode(type.getValue());

        rules.verify();
        return this.choose(fileChooser);
    }

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
