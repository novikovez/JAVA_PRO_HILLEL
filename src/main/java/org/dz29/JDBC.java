package org.dz29;

import org.dz29.migrations.CreateEmployeesTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/hillel";
        String user = "hillel";
        String password = "hillel";

        return DriverManager.getConnection(url, user, password);
    }

    public static void migrate() {
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute(CreateEmployeesTable.migration());
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }

    }

}
