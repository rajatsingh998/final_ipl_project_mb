package com.company;



import java.util.ArrayList;
import java.util.HashMap;


public class Project {
    public static void main(String[] args) {


        String file="D:\\MY\\Mount blue\\matches.csv";
        String file1="D:\\MY\\Mount blue\\deliveries.csv";

        FileParsingClass fileParsingObject= new FileParsingClass();
        ArrayList<HashMap<String, String>> data= fileParsingObject.dataParsing(file);
        ArrayList<HashMap<String, String>> data1 = fileParsingObject.dataParsing(file1);



        ArrayList<AllSolution> allSolution = new ArrayList<>();

        allSolution.add(Matches.noOfMatchesPlayedFun(data));
        allSolution.add(Matches.noOfMatchesWonFun(data));
        allSolution.add(DeliveriesMatches.extraRunsFun(data,data1));
        allSolution.add(DeliveriesMatches.topEconomicalBowlerFun(data,data1));
        allSolution.add(Matches.noOfPlayerOfTheMatchFun(data));
        int i=1;
        for (AllSolution solution : allSolution) {
            AllSolution obj= new AllSolution();
            obj.queryName(i);
            solution.getSolution().forEach((k, v) -> System.out.printf("\n %-30s : %s", k, v));
            i++;
        }
    }
}
