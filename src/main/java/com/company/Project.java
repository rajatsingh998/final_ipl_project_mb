package com.company;
import java.util.ArrayList;
import static com.company.ConstantValues.*;


public class Project {
    public static void main(String[] args) {

        FileParsingClass fileParsingObject= new FileParsingClass();
        ArrayList<Matches> data= fileParsingObject.dataParsing(DATASET_OF_MATCHES);
        ArrayList<Deliveries> data1=fileParsingObject.dataParsing1(DATASET_OF_DELIVERIES);

        ArrayList<AllSolution> allSolutionObj = new ArrayList<>();

        allSolutionObj.add(Services.noOfMatchesPlayedFun(data));
        allSolutionObj.add(Services.noOfMatchesWonFun(data));
        allSolutionObj.add(Services.extraRunsFun(data,data1));
        allSolutionObj.add(Services.topEconomicalBowlerFun(data,data1));
        allSolutionObj.add(Services.noOfPlayerOfTheMatchFun(data));

        int i=0;
        System.out.print("\t\t\t\t"+TITLE);
        for (AllSolution solution : allSolutionObj) {

            System.out.print("\n\n"+QUERY_STRING[i++]);
            solution.getSolution().forEach((k, v) -> System.out.printf("\n %-30s : %s", k, v));
            System.out.println("\n\n\t\t\t\t\t****************************************");
        }
    }
}
