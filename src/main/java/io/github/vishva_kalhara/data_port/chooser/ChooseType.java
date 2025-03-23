package io.github.vishva_kalhara.data_port.chooser;

public enum ChooseType {
    FILES_ONLY(0),
    DIRECTORIES_ONLY(1),
    FILES_AND_DIRECTORIES(2);

    private final int value;

    ChooseType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
