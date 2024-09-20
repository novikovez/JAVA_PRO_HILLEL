package org.file_handler;


import java.io.File;

/**
 * Class org.file_handler.CreateDir
 * author Igor Novikov
 * 20.09.24
 */

public class CreateDir {
    public boolean handler() {
        File dir = new File("files");
        if (!dir.exists()) {
            return dir.mkdir();
        }
        return true;
    }
}
