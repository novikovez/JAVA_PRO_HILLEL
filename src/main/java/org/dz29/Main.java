package org.dz29;

import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) {
        JDBC.migrate();
        // Add
        System.out.println("Add..");
        Employee employee = new Employee();
        employee.setName("Igor")
                .setAge(25)
                .setPosition("Developer")
                .setSalary(2000.00f);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int id = employeeDAO.addEmployee(employee);

        // Show
        System.out.println("Show..");
        Employee employeeShow = employeeDAO.getEmployee(id);
        employee.setId(employeeShow.getId());
        System.out.println(employeeShow);

        // Update
        System.out.println("Update..");
        employee.setSalary(1000.00f);
        employeeDAO.updateEmployee(employee);
        Employee employeeShow2 = employeeDAO.getEmployee(id);
        System.out.println(employeeShow2);

        // Delete
        System.out.println("Delete..");
        employeeDAO.deleteEmployee(employee);

    }
}
