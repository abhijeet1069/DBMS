package com.satyam.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DatabaseExample {
    public static void main(String[] args) {
        // H2 in-memory database URL
        String jdbcUrl = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to H2 Database!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Create a table
            String createTableSQL = "CREATE TABLE users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "email VARCHAR(50))";
            statement.execute(createTableSQL);
            System.out.println("Table 'users' created.");

            // Insert data into the table
            String insertDataSQL = "INSERT INTO users (name, email) VALUES " +
                    "('Alice', 'alice@example.com')," +
                    "('Bob', 'bob@example.com')";
            statement.executeUpdate(insertDataSQL);
            System.out.println("Data inserted into 'users' table.");

            // Retrieve data from the table
            String selectSQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            // Display data
            System.out.println("Users in the database:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.printf("ID: %d, Name: %s, Email: %s%n", id, name, email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
