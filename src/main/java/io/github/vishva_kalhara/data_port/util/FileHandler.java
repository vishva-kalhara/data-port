package io.github.vishva_kalhara.data_port.util;

import javax.swing.*;
import java.awt.*;

public class FileHandler {

    private final Component parent;
    private final JFileChooser fileChooser;

    public FileHandler(Component parent){
        this.parent = parent;
        this.fileChooser = new JFileChooser();
    }

    public String chooseFile() {

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        return this.choose(fileChooser);
    }

    public String chooseFolder(){

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        return this.choose(fileChooser);
    }


    public String choose(){

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
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
