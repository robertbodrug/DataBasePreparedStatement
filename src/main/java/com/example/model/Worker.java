package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {
    private int id;
    private String name;
    private String birthday;
    private String level;
    private int salary;
}
