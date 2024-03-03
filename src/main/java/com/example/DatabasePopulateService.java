package com.example;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Set;

import static com.example.Database.getInstance;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {

        Connection connection = getInstance().getConnection();
        try (Statement statement = connection.createStatement();)
        {
            connection.setAutoCommit(false);
            for (String query: QueryToString.toQueries(new File("sql\\\\populate_db.sql"))) {
                statement.executeUpdate(query);
            }
            connection.commit();
        } catch(Exception ex) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }





//        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.toQuery(new File("sql\\populate_db.sql")))) {
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
