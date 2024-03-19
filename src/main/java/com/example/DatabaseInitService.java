package com.example;

import java.io.File;
import java.sql.*;

public class DatabaseInitService {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
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
