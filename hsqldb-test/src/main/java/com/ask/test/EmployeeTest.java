package com.ask.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ask.domain.Employee;
import com.ask.util.ConnectionUtil;

public class EmployeeTest
{

    private Connection connection;

    public void createTable() throws SQLException
    {
        String query = "CREATE TABLE employee ( id INTEGER IDENTITY, name VARCHAR(256), salary INTEGER)";
        connection = ConnectionUtil.getConnection();
        int i = connection.createStatement().executeUpdate(query);
        if (i == -1)
        {
            System.err.println("Failed to create table: " + query);
        }
        connection.close();
    }

    public int insert(Employee emp) throws SQLException
    {
        try
        {
            connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO employee(name,salary) values(?,?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setInt(2, emp.getSalary());
            return preparedStatement.executeUpdate();
        }
        finally
        {
            connection.commit();
            connection.close();
        }
    }

    public List<Employee> getEmployees() throws SQLException
    {
        try
        {
            List<Employee> employees = new ArrayList<Employee>();
            connection = ConnectionUtil.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM EMPLOYEE");
            while (resultSet.next())
            {
                employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
            }
            return employees;
        }
       finally
        {
           connection.close();
        }
    }
    
    public static void main(String[] args)
    {
        try
        {
            EmployeeTest employeeTest = new EmployeeTest();
           employeeTest.createTable();
            for (int i = 0; i < 6; i++)
            {
                employeeTest.insert(new Employee("Gaurav-"+i, (int)(Math.random()*10000)));
                
            }
            
            System.out.println("All Employees\nID NAME   SALARY");
            for (Employee emp: employeeTest.getEmployees())
            {
            System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());    
            }
            ConnectionUtil.shutdown();
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}

