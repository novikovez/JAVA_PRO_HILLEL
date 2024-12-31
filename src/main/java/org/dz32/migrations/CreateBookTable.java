package org.dz32.migrations;

public class CreateBookTable {
    public static String migration() {
        return  "CREATE TABLE IF NOT EXISTS books (" +
                "id SERIAL PRIMARY KEY, " +
                "author VARCHAR(100), " +
                "title VARCHAR(100)" +
                ");";
    }
}
