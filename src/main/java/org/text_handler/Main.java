package org.text_handler;


import org.file_handler.*;

/**
 * Class org.text_handler.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {
    private static final CreateDir createDir = new CreateDir();


    public static void main(String[] args) {
        createDir.handler();
        FileHandler handler = new FileHandler();
        getOutput(handler.createFile());
        getOutput(handler.writeToFile(ConfigEnum.TEXT.getTitle()));
        getOutput(ConfigEnum.RESULT.getTitle() + handler.readFromFile());
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
