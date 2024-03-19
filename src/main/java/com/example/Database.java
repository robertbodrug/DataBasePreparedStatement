package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Database {
    private static Connection connection;
    private static String DB_URL = "jdbc:h2:~/test";
    private static String USERNAME = "sa";
    private static String PASSWORD = "";

    private Database(){

    }

    public static Connection getConnection(){
        if (Objects.isNull(connection)){
            try {
                connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

}

