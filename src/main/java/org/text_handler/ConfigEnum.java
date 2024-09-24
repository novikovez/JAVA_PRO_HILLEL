package org.text_handler;

public enum ConfigEnum {
    PATH ("files/"),
    FILENAME ("myfile.txt"),
    TEXT("Super information."),
    RESULT("CONTENT: ");

    private final String title;

    ConfigEnum(String file) {
        this.title = file;
    }

    public String getTitle() {
        return title;
    }
}
