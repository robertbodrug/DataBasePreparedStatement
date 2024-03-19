package com.example;


import com.example.model.Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String[] split = "1,2,2023-01-01, 2025-05-01,2,3,2023-08-15, 2025-11-01,3,5,2022-04-10, 2024-06-01,4,4,2023-10-12, 2026-10-01,5,4,2023-06-15, 2027-07-01,6,2,2021-09-21,2027-01-01,7,3,2022-03-30,2025-02-01,8,3,2023-06-16,2024-08-01,9,2,2019-11-26,2024-09-01,10,3,2024-01-01,2027-05-01,".split("");
        StringBuilder a = new StringBuilder();
        for (String b:split){
            if(!b.equals(" ")&&!b.equals("(")&&!b.equals(")"))a.append(b);
        }
        System.out.println(a);
    }
}