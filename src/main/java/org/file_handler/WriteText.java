package org.file_handler;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Class org.file_handler.Write
 * author Igor Novikov
 * 20.09.24
 */

public class WriteText {

    public String handle() {
        try (PrintWriter writer = new PrintWriter(ConfigEnum.PATH.getTitle()
                + ConfigEnum.FILENAME.getTitle(),
                StandardCharsets.UTF_8)
        ) {
            writer.println(ConfigEnum.TEXT.getTitle());
            return "Success";
        } catch (IOException e) {
            return "Error";
        }
    }
}
