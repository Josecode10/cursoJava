package demo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {
    // IMPORTANT: Update these constants with your own database credentials and details.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    // The name of the table we will be interacting with.
    private static final String TABLE_NAME = "users";

    /**
     * Establishes a connection to the MySQL database.
     * @return A valid Connection object or null if the connection fails.
     */
    private static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver class.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the database connection.
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connection to database established.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Creates a new table named 'users' if it doesn't already exist.
     */
    public static void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                             "id INT PRIMARY KEY AUTO_INCREMENT," +
                             "name VARCHAR(50) NOT NULL," +
                             "email VARCHAR(100) NOT NULL UNIQUE" +
                             ")";
                statement.executeUpdate(sql);
                System.out.println("Table '" + TABLE_NAME + "' created successfully (or already exists).");
            }
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manually close the resources in a finally block.
            closeResources(connection, statement, null);
        }
    }

    /**
     * Inserts a new user record into the 'users' table.
     * @param scanner The Scanner object for user input.
     */
    public static void insertData(Scanner scanner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            if (connection != null) {
                System.out.print("Enter user name: ");
                String name = scanner.nextLine();
                System.out.print("Enter user email: ");
                String email = scanner.nextLine();

                String sql = "INSERT INTO " + TABLE_NAME + " (name, email) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manually close the resources.
            closeResources(connection, preparedStatement, null);
        }
    }

    /**
     * Reads and prints all user records from the 'users' table.
     */
    public static void readData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "SELECT * FROM " + TABLE_NAME;
                resultSet = statement.executeQuery(sql);

                System.out.println("\n--- User Data ---");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error reading data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manually close the resources.
            closeResources(connection, statement, resultSet);
        }
    }

    /**
     * Updates a user's name and email based on their ID.
     * @param scanner The Scanner object for user input.
     */
    public static void updateData(Scanner scanner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            if (connection != null) {
                System.out.print("Enter the ID of the user to update: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline.

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();

                String sql = "UPDATE " + TABLE_NAME + " SET name = ?, email = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " row(s) updated successfully.");
                } else {
                    System.out.println("No user found with ID " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manually close the resources.
            closeResources(connection, preparedStatement, null);
        }
    }

    /**
     * Deletes a user record based on their ID.
     * @param scanner The Scanner object for user input.
     */
    public static void deleteData(Scanner scanner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            if (connection != null) {
                System.out.print("Enter the ID of the user to delete: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline.

                String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " row(s) deleted successfully.");
                } else {
                    System.out.println("No user found with ID " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manually close the resources.
            closeResources(connection, preparedStatement, null);
        }
    }

    /**
     * A helper method to safely close JDBC resources.
     * @param connection The Connection object to close.
     * @param statement The Statement or PreparedStatement object to close.
     * @param resultSet The ResultSet object to close.
     */
    private static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        // Closing the ResultSet
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        // Closing the Statement
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Error closing Statement: " + e.getMessage());
            }
        }
        // Closing the Connection
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing Connection: " + e.getMessage());
            }
        }
    }
}
