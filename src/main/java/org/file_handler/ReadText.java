package org.file_handler;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class org.file_handler.ReadText
 * author Igor Novikov
 * 20.09.24
 */

public class ReadText {

    public String handle() {
        try {
            Path file = Paths.get(ConfigEnum.PATH.getTitle() + ConfigEnum.FILENAME.getTitle());
            return Files.readString(file, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            return "File Not Found";
        }

    }

}
