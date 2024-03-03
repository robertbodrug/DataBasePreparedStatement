package com.example;


import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DatabaseQueryService {


    public record MaxSalaryWorker(String name, int salary) {
    }

    public record MaxProjectsClient(String name, int projectCount) {
    }

    public record LongestProject(int id, int monthCount) {
    }

    public record YoungestEldestWorkers(String type, String name, LocalDate birthday) {
    }

    public record ProjectPrices(int id, int price) {
    }


    public static List<MaxProjectsClient> findMaxProjectsClient() {

        List<MaxProjectsClient> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.toQuery(new File("sql\\find_max_projects_client.sql")));
             Scanner scanner = new Scanner(System.in);) {

            System.out.println("How many customers to show?");
            statement.setInt(1, scanner.nextInt());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new MaxProjectsClient(resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public static List<MaxSalaryWorker> findMaxSalaryWorker() {

        List<MaxSalaryWorker> result = new LinkedList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(QueryToString.toQuery(new File("sql\\find_max_salary_worker.sql")));
            while (resultSet.next()) {
                result.add(new MaxSalaryWorker(resultSet.getString(1), resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<LongestProject> findLongestProject(){

        List<LongestProject> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.toQuery(new File("sql\\find_longest_project.sql")));
            Scanner scanner = new Scanner(System.in);) {

                System.out.println("How many projects to show?");
                statement.setInt(1, scanner.nextInt());
                ResultSet resultSet = statement.executeQuery();
                 while (resultSet.next()){
                    result.add(new LongestProject(resultSet.getInt(1), resultSet.getInt(2)));
                 }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<YoungestEldestWorkers> findYoungestEldestWorkers(){

        List<YoungestEldestWorkers> result = new LinkedList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(QueryToString.toQuery(new File("sql\\find_youngest_eldest_workers.sql")));
            while (resultSet.next()){
                result.add(new YoungestEldestWorkers(resultSet.getString(1),resultSet.getString(2),LocalDate.parse(resultSet.getString(3))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static List<ProjectPrices> findProjectPrices(){

        List<ProjectPrices> result = new LinkedList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(QueryToString.toQuery(new File("sql\\print_project_prices.sql")));
            while (resultSet.next()){
                result.add(new ProjectPrices(resultSet.getInt(1),resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
