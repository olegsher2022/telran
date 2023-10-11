package org.example;

import org.testng.annotations.Test;

import java.sql.*;

public class CreateDataBaseAndTables {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://172.17.0.2:3306/";
        String username = "root";
        String password = "12345678";
        String databaseName = "oleg";


        // SQL statements for database creation and table creation
        String dropIfExist = "DROP DATABASE IF EXISTS " + databaseName;
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        String useDatabaseSQL = "USE " + databaseName;
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "username VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL"
                + ")";
        String insertInto = "INSERT INTO users VALUES ";


        try {
            // Connect to MySQL server
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            statement.execute(dropIfExist);


            // Create the database (if it doesn't exist)
            statement.executeUpdate(createDatabaseSQL);

            // Use the database
            statement.execute(useDatabaseSQL);



            // Create the table (if it doesn't exist)
            Statement st = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            st.close();

            System.out.println("Database and table created successfully!");

            for (int i=1; i<10; i++){
                statement.execute(insertInto + "(" + i + ",\"oleg\", \"oleg@sher.biz\")");
            }

            ResultSet rs = statement.executeQuery("SELECT * FROM users;");
            while (rs.next()){
                System.out.println(rs.getInt("id") + rs.getString("username") + rs.getString("email"));
            }


            // Close the resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}