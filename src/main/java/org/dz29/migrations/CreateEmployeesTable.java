package org.dz29.migrations;

public class CreateEmployeesTable {
    public static String migration() {
        return  "CREATE TABLE IF NOT EXISTS employees (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "age INTEGER, " +
                "position VARCHAR(100), " +
                "salary FLOAT)";
    }
}
