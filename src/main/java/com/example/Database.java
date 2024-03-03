package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection connection;
    private static final Database database = new Database();

    private Database(){
        String dbUrl = "jdbc:h2:~/test";
        String dbUser = "sa";
        String dbPass = "";
        try{
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Connected to database");
        }
        catch (SQLException e) {
            System.err.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static Database getInstance(){
     return database;
    }
}

