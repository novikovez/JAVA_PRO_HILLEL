package org.dz24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private static final String file = "log.txt";

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        try {
            Files.write(Paths.get(file), (LocalDateTime.now().
                            format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                            + " - " + message + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton instance!");
    }
}
