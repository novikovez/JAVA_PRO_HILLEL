package org.file_handler;


import java.io.FileReader;
import java.io.IOException;

/**
 * Class org.file_handler.ReadFile
 * author Igor Novikov
 * 20.09.24
 */

public class ReadFile {
    public String handle () {
        try (FileReader reader = new FileReader(ConfigEnum.PATH.getTitle() + ConfigEnum.FILENAME_2.getTitle())) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return "File Not Found";
        }
    }
}
