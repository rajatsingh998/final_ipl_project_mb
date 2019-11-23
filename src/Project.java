package com.company;



import java.util.ArrayList;
import java.util.HashMap;

import static com.company.ConstantValues.*;
public class Project {
    public static void main(String[] args) {

        FileParsingClass fileParsingObject= new FileParsingClass();
        ArrayList<HashMap<String, String>> data= fileParsingObject.dataParsing(MATCHES);
        ArrayList<HashMap<String, String>> data1 = fileParsingObject.dataParsing(DELIVERIES);

        ArrayList<AllSolution> allSolution = new ArrayList<>();

        allSolution.add(Matches.noOfMatchesPlayedFun(data));
        allSolution.add(Matches.noOfMatchesWonFun(data));
        allSolution.add(DeliveriesMatches.extraRunsFun(data,data1));
        allSolution.add(DeliveriesMatches.topEconomicalBowlerFun(data,data1));
        allSolution.add(Matches.noOfPlayerOfTheMatchFun(data));

        int i=0;
        System.out.print("\t\t\t\t"+TITLE);
        for (AllSolution solution : allSolution) {

            System.out.print("\n\n"+QUERY_STRING[i++]);
            solution.getSolution().forEach((k, v) -> System.out.printf("\n %-30s : %s", k, v));
            System.out.println("\n\n\t\t\t\t\t****************************************");
        }
    }
}
