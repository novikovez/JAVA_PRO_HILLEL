package org.file_handler;

public enum ConfigEnum {
    PATH ("files/"),
    FILENAME ("file.txt"),
    FILENAME_2 ("file.ttp"),
    TEXT ("My very important information TXT"),
    TEXT_FROM_FILE ("My very important information TTP");

    private final String title;

    ConfigEnum(String file) {
        this.title = file;
    }

    public String getTitle() {
        return title;
    }
}
