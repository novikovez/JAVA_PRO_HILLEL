package org.dz32;
import org.dz32.migrations.CreateBookTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/hillel",
                "hillel",
                "hillel"
        );
    }

    public static void migrate() {
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute(CreateBookTable.migration());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

