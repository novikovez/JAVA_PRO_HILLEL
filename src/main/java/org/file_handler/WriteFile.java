package org.file_handler;


import java.io.FileWriter;

/**
 * Class org.file_handler.WriteFile
 * author Igor Novikov
 * 20.09.24
 */

public class WriteFile {

    public String handle() {
        try(FileWriter fw = new FileWriter(ConfigEnum.PATH.getTitle() + ConfigEnum.FILENAME_2.getTitle())) {
            fw.write(ConfigEnum.TEXT_FROM_FILE.getTitle());
            return "Success";
        } catch (Exception e) {
            return "Error";
        }
    }
}
