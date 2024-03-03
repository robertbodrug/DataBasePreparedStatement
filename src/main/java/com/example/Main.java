package com.example;



public class Main {

    public static void main(String[] args) {
        //DatabaseQueryService.findLongestProject().stream().forEach(System.out::println);
        DatabaseQueryService.findMaxProjectsClient().stream().forEach(System.out::println);
        DatabaseQueryService.findMaxSalaryWorker().stream().forEach(System.out::println);
        DatabaseQueryService.findYoungestEldestWorkers().stream().forEach(System.out::println);
        DatabaseQueryService.findProjectPrices().stream().forEach(System.out::println);

    }
}