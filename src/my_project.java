package com.company;

import java.util.*;

public class my_project {
    public static void main(String[] args) {

        System.out.println("====== IPL DATASET PROJECT =====");
        System.out.println("\n Choose one of the option");
        System.out.println("\n 1. Number of matches played per year of all the years in IPL.");
        System.out.println("\n 2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("\n 3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("\n 4. For the year 2015 get the top economical bowlers.");
        System.out.println("\n 5. Total number of the player of the match award by players");

        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        String file="matches.csv";
        String file1="deliveries.csv";

        HashMap<String, Integer> solution = getSolution.allSolution(response,file, file1);
        solution.forEach((k, v) -> System.out.printf("\n %-30s : %d", k, v));

    }
}
