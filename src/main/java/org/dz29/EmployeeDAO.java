package org.dz29;

import java.sql.*;

public class EmployeeDAO
{
    public int addEmployee(Employee employee) {
        String insertEmployee = "INSERT INTO employees(name, age, position, salary) VALUES (?, ?, ?, ?)";

        try(Connection connection = JDBC.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setFloat(4, employee.getSalary());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void deleteEmployee(Employee employee) {
        String deleteEmployee = "DELETE FROM employees WHERE id = ?";

        try(Connection connection = JDBC.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployee);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        String updateEmployee = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try(Connection connection = JDBC.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateEmployee);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setFloat(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee getEmployee(int id) {
        String getEmployee = "SELECT * FROM employees WHERE id = ?";
        try(Connection connection = JDBC.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(getEmployee);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Employee employee = new Employee();
                return employee.setId(result.getInt("id"))
                        .setName(result.getString("name"))
                        .setAge(result.getInt("age"))
                        .setPosition(result.getString("position"))
                        .setSalary(result.getFloat("salary"));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        String getAllEmployees = "SELECT * FROM employee";
        return null;
    }
}
