package org.file_handler;


import org.word_convertor.config.Config;

import java.io.IOException;

/**
 * Class org.file_handler.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {
    private static final String RUN = "RESULT: ";
    private static final String END = "FILE CONTENT: ";

    private static final CreateDir createDir = new CreateDir();
    private static final WriteText writeText = new WriteText();
    private static final ReadText readText = new ReadText();
    private static final WriteFile writeFile = new WriteFile();
    private static final ReadFile readFile = new ReadFile();

    public static void main(String[] args) {
        createDir.handler();
        getOutput(RUN + writeText.handle());
        getOutput(END + readText.handle());
        getOutput(RUN + writeFile.handle());
        getOutput(RUN + readFile.handle());
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
