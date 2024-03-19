package com.example;

import com.example.model.Client;
import com.example.model.Project;
import com.example.model.Worker;

import java.io.File;
import java.sql.*;

import java.util.Scanner;



public class DatabasePopulateService {


    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        initWorker(connection);
        initClient(connection);
        initProject(connection);
        initProjectWorker(connection);
    }


    private static void initWorker(Connection connection) throws SQLException {
        String sql = "INSERT INTO WORKER (ID,NAME,BIRTHDAY,LEVER,SALARY) VALUES (?,?,?,?,?);";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(new File("sql/worker_data.txt")).useDelimiter(",");
        ) {
            while (scanner.hasNext()) {
                Worker worker = new Worker(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt());
                statement.setInt(1, worker.getId());
                statement.setString(2, worker.getName());
                statement.setDate(3, Date.valueOf(worker.getBirthday()));
                statement.setString(4, worker.getLevel());
                statement.setInt(5, worker.getSalary());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (Exception ex) {
            System.out.println(ex.getClass());

        }
    }

    private static void initClient(Connection connection) throws SQLException {
        String sql = "INSERT INTO CLIENT(ID,NAME) VALUES (?,?);";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(new File("sql/client_data.txt")).useDelimiter(",");
        ) {
            while (scanner.hasNext()) {
            Client client = new Client(scanner.nextInt(),scanner.next());
            statement.setInt(1, client.getId());
            statement.setString(2, client.getName());
            statement.addBatch();
            }
            statement.executeBatch();

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            throw new  RuntimeException();
        }
    }

    private static void initProject(Connection connection) throws SQLException {
        String sql = "INSERT INTO PROJECT(ID,CLIENT_ID,START_DATE,FINISH_DATE)VALUES(?,?,?,?);";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(new File("sql/project_data.txt")).useDelimiter(",");
        ) {
            while (scanner.hasNext()) {
                Project project = new Project(scanner.nextInt(),scanner.nextInt(),scanner.next(),scanner.next());
                statement.setInt(1, project.getId());
                statement.setInt(2, project.getClientId());
                statement.setDate(3, Date.valueOf(project.getStart()));
                statement.setDate(4, Date.valueOf(project.getFinish()));
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (Exception ex) {
            System.out.println(ex.getClass());

        }
    }

    private static void initProjectWorker(Connection connection) throws SQLException {
        String sql = "INSERT INTO PROJECT_WORKER(PROJECT_ID,WORKER_ID) VALUES (?,?);";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(new File("sql/project_worker_data.txt")).useDelimiter(",");
        ) {
            while (scanner.hasNext()) {
                statement.setInt(1, scanner.nextInt());
                statement.setInt(2, scanner.nextInt());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            throw new  RuntimeException();
        }
    }

}