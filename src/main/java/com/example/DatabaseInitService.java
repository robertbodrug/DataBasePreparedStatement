package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

import static com.example.Database.*;
import static java.sql.DriverManager.getConnection;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        Connection connection = getInstance().getConnection();
        try (Statement statement = connection.createStatement();)
        {
            connection.setAutoCommit(false);
            for (String query: QueryToString.toQueries(new File("sql\\init_db.sql"))) {
            statement.executeUpdate(query);
        }
            connection.commit();
            System.out.println("Database init");
        } catch(Exception ex) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

//        try (Database.getInstance().getConnection()
//                PreparedStatement statement = prepareStatement(QueryToString.convert(new File("sql\\init_db.sql")))) {
//                statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    }
