package org.text_handler;


import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;


/**
 * Class org.text_handler.FileHandler
 * author Igor Novikov
 * 24.09.24
 */

public class FileHandler {
    private final static Path PATH = Path.of(ConfigEnum.PATH.getTitle() + ConfigEnum.FILENAME.getTitle());

    public String createFile() {
        Path newFile;
        try {
            newFile = Files.createFile(PATH);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(String content) {
        try {
            Files.writeString(PATH, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + PATH;
    }

    public String readFromFile() {
        try {
            return readString(PATH);
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}
