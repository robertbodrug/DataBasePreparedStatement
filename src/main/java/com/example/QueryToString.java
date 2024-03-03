package com.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class QueryToString {

    public static List<String> toQueries(File file) {
        List<String> result = new LinkedList<>();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            while (scanner.hasNext()) {
                String query = scanner.useDelimiter(";").next();
                result.add(query);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String toQuery(File file) {
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            return scanner.hasNext()?scanner.useDelimiter(";").next():"";
            }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
